package com.jafan.cfteaching.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jafan.cfteaching.data.Aluno
import com.jafan.cfteaching.databinding.ListItemBinding

class AlunoAdapter (private val onItemCliked: (Aluno) -> Unit):
    ListAdapter<Aluno, AlunoAdapter.AlunoViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AlunoAdapter.AlunoViewHolder {
        val viewHolder = AlunoViewHolder(
            ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemCliked(getItem(position))
        }
        return viewHolder
    }

    override fun onBindViewHolder(holder: AlunoAdapter.AlunoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class AlunoViewHolder (private var binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(aluno: Aluno) {
            binding.nomeTexto.text = aluno.nome
        }

    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Aluno>() {
            override fun areItemsTheSame(oldItem: Aluno, newItem: Aluno): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Aluno, newItem: Aluno): Boolean {
                return oldItem == newItem
            }
        }
    }

}