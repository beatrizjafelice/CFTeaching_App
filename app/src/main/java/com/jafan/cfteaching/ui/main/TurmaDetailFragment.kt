package com.jafan.cfteaching.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.jafan.cfteaching.R
import com.jafan.cfteaching.adapter.AlunoAdapter
import com.jafan.cfteaching.data.entities.Turma
import com.jafan.cfteaching.data.lista_turmas
import com.jafan.cfteaching.databinding.FragmentTurmaDetailBinding

class TurmaDetailFragment: Fragment() {

    private var _binding: FragmentTurmaDetailBinding? = null
    private val binding get() = _binding!!

    private lateinit var turma: Turma
    private val navigationArgs: TurmaDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTurmaDetailBinding.inflate(inflater, container, false)

        val adapter = AlunoAdapter {}
        binding.recyclerAlunosTurma.adapter = adapter
        binding.recyclerAlunosTurma.layoutManager = LinearLayoutManager(requireContext())
        adapter.submitList(turma.alunos)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val turmaId = navigationArgs.id
        for (item in lista_turmas) {
            if (item.id == turmaId) {
                turma = item
            }
        }

        binding.apply {
            nome.text = turma.nomeTurma
            curso.text = getString(R.string.curso_aluno, turma.curso)
            valor.text = getString(R.string.valor_hora, "50,0")
            duracao.text = getString(R.string.tempo_aula, "30")
            precoMes.text = getString(R.string.valor_mes, "350,0")
        }




    }
}