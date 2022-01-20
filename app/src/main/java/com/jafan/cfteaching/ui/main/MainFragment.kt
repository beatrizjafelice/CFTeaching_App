package com.jafan.cfteaching.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.jafan.cfteaching.adapter.SectionsPagerAdapter
import com.jafan.cfteaching.databinding.FragmentMainBinding

class MainFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    val titles = arrayOf(
        "Alunos",
        "Turmas"
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val tabLayout = binding.tabs
        val viewPager = binding.viewPager
        val adapter = SectionsPagerAdapter(this)
        viewPager.adapter = adapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()


        // Floating Action Button
        val fab: FloatingActionButton = binding.fab
        val action = MainFragmentDirections.actionMainFragmentToAddAlunoFragment()
        fab.setOnClickListener { _ ->
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showDialog() {
        val items = arrayOf("Aluno", "Turma")
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Adicionar novo")
            .setItems(items) { _, id ->
                addNew(id)
            }
    }

    private fun addNew(id: Int) {
        // TODO: implement
    }


}