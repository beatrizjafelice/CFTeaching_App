package com.jafan.cfteaching.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jafan.cfteaching.ui.main.AlunosFragment
import com.jafan.cfteaching.ui.main.TurmasFragment


class SectionsPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> AlunosFragment()
            else -> TurmasFragment()
        }
    }


}

