package com.jafan.cfteaching.ui.main

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.jafan.cfteaching.R
import com.jafan.cfteaching.databinding.FragmentAddAlunoBinding
import com.jafan.cfteaching.model.TurmaViewModel
import java.util.*



class AddAlunoFragment: Fragment() {

    private var _binding: FragmentAddAlunoBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddAlunoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            addAlunoFragment = this@AddAlunoFragment
        }


        // configura formulário:
        dropdownMenus()




    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_add_grupo, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //R.id.opcao_add_a_um_grupo -> // TODO: adiciona a um grupo existente (se houver grupos) ou cria um novo
            //R.id.opcao_salvar_aluno -> // TODO: função salvar aluno
        }
        return super.onOptionsItemSelected(item)

    }

    private fun dropdownMenus() {
        //cursos:
        val cursos = resources.getStringArray(R.array.curso_menu)
        val menuCursoAdapter = ArrayAdapter(requireContext(), R.layout.menu_item, cursos)
        binding.cursoDropdown.setAdapter(menuCursoAdapter)

        // duração da aula:
        val temposAula = resources.getStringArray(R.array.duracao_menu)
        val menuDuracaoAdapter = ArrayAdapter(requireContext(), R.layout.menu_item, temposAula)
        binding.duracaoDropdown.setAdapter(menuDuracaoAdapter)

        // meses:
        val meses = resources.getStringArray(R.array.meses)
        val menuMesesAdapter = ArrayAdapter(requireContext(), R.layout.menu_item, meses)
        binding.mesInput.setAdapter(menuMesesAdapter)

        // anos:
        val anos = arrayOf(0, 1, 2, 3)
        // mostra como opções o ano atual + 3 próximos anos
        val current = Calendar.getInstance().get(Calendar.YEAR)
        repeat(4) {
            anos[it] = current.plus(it)
        }
        val anosAdapter = ArrayAdapter(requireContext(), R.layout.menu_item, anos)
        binding.anoInput.setAdapter(anosAdapter)

    }

    fun diasDaSemanaDialog() {
        val dias = arrayOf("Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado", "Domingo")
        val selected = mutableMapOf<Int, String>()
        val checkedArray = booleanArrayOf(false, false, false, false, false, false, false)
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(resources.getString(R.string.dialog_dias_semana))
            .setMultiChoiceItems(dias, checkedArray) { _, itemId, checked ->
                if (checked) {
                    selected[itemId] = dias[itemId]
                } else {
                    selected.remove(itemId)
                }
            }
            .setNeutralButton(resources.getString(R.string.cancelar)) { dialog, _ ->
                dialog.dismiss()
            }
            // monta uma string correspondente aos dias selecionados e mostra no edit text
            .setPositiveButton(resources.getString(R.string.ok)) { _, _ ->
                val sorted = selected.toSortedMap()
                val s = StringBuilder()
                sorted.onEachIndexed { index, diaId ->
                    if (index == sorted.size - 1) {
                        s.append(diaId.value)
                    } else {
                        s.append("${diaId.value}, ")
                    }
                }
                binding.campoDiasDaSemana.setText(s.toString())
            }.show()
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}