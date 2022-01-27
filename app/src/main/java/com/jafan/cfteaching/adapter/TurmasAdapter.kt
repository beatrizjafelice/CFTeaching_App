package com.jafan.cfteaching.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jafan.cfteaching.data.entities.Turma
import com.jafan.cfteaching.databinding.MainListItemBinding

class TurmasAdapter (private val onItemCliked: (Turma) -> Unit):
    ListAdapter<Turma, TurmasAdapter.TurmasViewHolder>(DiffCallback) {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TurmasAdapter.TurmasViewHolder {
        val viewHolder = TurmasViewHolder(
            MainListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemCliked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: TurmasAdapter.TurmasViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class TurmasViewHolder (private var binding: MainListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(turma: Turma) {
            binding.nomeTexto.text = turma.nomeTurma
        }

    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Turma>() {
            override fun areItemsTheSame(oldItem: Turma, newItem: Turma): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Turma, newItem: Turma): Boolean {
                return oldItem == newItem
            }
        }
    }

}