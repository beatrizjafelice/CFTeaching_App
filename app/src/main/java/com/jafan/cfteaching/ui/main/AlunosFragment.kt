package com.jafan.cfteaching.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jafan.cfteaching.adapter.AlunoAdapter
import com.jafan.cfteaching.data.lista_alunos
import com.jafan.cfteaching.databinding.FragmentAlunosBinding

class AlunosFragment: Fragment() {

    private var _binding: FragmentAlunosBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAlunosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerAlunos = binding.alunosRecycler
        recyclerAlunos.layoutManager = LinearLayoutManager(requireContext())
        val adapter = AlunoAdapter {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAlunoDetailFragment(id = it.id))
        }
        val data = lista_alunos
        recyclerAlunos.adapter = adapter
        adapter.submitList(data)


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}