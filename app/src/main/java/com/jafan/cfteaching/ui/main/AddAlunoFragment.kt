package com.jafan.cfteaching.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.checkbox.MaterialCheckBox
import com.jafan.cfteaching.R
import com.jafan.cfteaching.databinding.FragmentAddAlunoBinding

class AddAlunoFragment: Fragment() {

    private var _binding: FragmentAddAlunoBinding? = null
    private val binding get() = _binding!!

    private lateinit var grupoCheck: MaterialCheckBox
    private lateinit var ativoCheck: MaterialCheckBox
    private lateinit var botaoAddGrupo: Button


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

        dropdownMenus()

        // opção grupo:
        grupoCheck = binding.turmaCheck
        botaoAddGrupo = binding.botaoAddTurma
        if (grupoCheck.isChecked) {
            botaoAddGrupo.visibility = View.VISIBLE
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun dropdownMenus() {
        // cursos:
        val cursos = resources.getStringArray(R.array.curso_menu)
        val menuCursoAdapter = ArrayAdapter(requireContext(), R.layout.menu_item, cursos)
        val cursoTextView = binding.cursoDropdown
        cursoTextView.setAdapter(menuCursoAdapter)

        // duração da aula:
        val temposAula = resources.getStringArray(R.array.duracao_menu)
        val menuDuracaoAdapter = ArrayAdapter(requireContext(), R.layout.menu_item, temposAula)
        val duracaoTextView = binding.duracaoDropdown
        duracaoTextView.setAdapter(menuDuracaoAdapter)
    }
}