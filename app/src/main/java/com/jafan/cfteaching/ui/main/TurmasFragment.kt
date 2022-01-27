package com.jafan.cfteaching.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jafan.cfteaching.R
import com.jafan.cfteaching.adapter.SectionsPagerAdapter
import com.jafan.cfteaching.adapter.TurmasAdapter
import com.jafan.cfteaching.data.lista_turmas
import com.jafan.cfteaching.databinding.FragmentTurmasBinding

class TurmasFragment: Fragment() {

    private var _binding: FragmentTurmasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTurmasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerTurmas = binding.turmasRecycler
        recyclerTurmas.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TurmasAdapter {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToTurmaDetailFragment(id = it.id))
        }
        recyclerTurmas.adapter = adapter
        val data = lista_turmas
        adapter.submitList(data)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}