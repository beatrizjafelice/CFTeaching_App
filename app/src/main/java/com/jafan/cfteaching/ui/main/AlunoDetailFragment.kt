package com.jafan.cfteaching.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.jafan.cfteaching.R
import com.jafan.cfteaching.data.entities.Aluno
import com.jafan.cfteaching.data.lista_alunos
import com.jafan.cfteaching.databinding.FragmentAlunoDetailBinding

class AlunoDetailFragment: Fragment() {

    private var _binding: FragmentAlunoDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var aluno: Aluno
    private val navigationArgs: AlunoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlunoDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val alunoID = navigationArgs.id
        for (item in lista_alunos) {
            if (item.id == alunoID) {
                aluno = item
            }
        }

        binding.apply {
            nome.text = aluno.nome
            curso.text = getString(R.string.curso_aluno, aluno.curso)
            ativo.text = if (aluno.ativo) {
                getString(R.string.status, "ativo")
            } else {
                getString(R.string.status, "não ativo")
            }
            telefone.text = aluno.telefone
            /*valor.text = getString(R.string.valor_hora, aluno.valorHora.toString())
            duracao.text = getString(R.string.tempo_aula, aluno.tempoAula.toString())
            precoMes.text = getString(R.string.valor_mes, aluno.valorMes.toString())*/
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}