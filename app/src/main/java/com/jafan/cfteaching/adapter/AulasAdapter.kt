package com.jafan.cfteaching.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.jafan.cfteaching.R
import com.jafan.cfteaching.data.entities.Aula
import com.jafan.cfteaching.databinding.AulaListItemBinding


class AulasAdapter (private val onItemClicked: (Aula) -> Unit):
    ListAdapter<Aula, AulasAdapter.AulaViewHolder>(DiffCallback) {


    class AulaViewHolder(private val context: Context?, private val binding: AulaListItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(aula: Aula) {
            binding.tituloAula.text = context?.resources?.getString(R.string.data,
                aula.diaSemana, aula.dia.toString(), aula.mes.toString(), aula.ano.toString())
            binding.horaAula.text = context?.resources?.getString(R.string.horario, aula.horarioInicio, aula.horarioFim)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AulasAdapter.AulaViewHolder {
        val viewHolder = AulasAdapter.AulaViewHolder(parent.context, AulaListItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))

        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            onItemClicked(getItem(position))
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: AulasAdapter.AulaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Aula>() {
            override fun areItemsTheSame(oldItem: Aula, newItem: Aula): Boolean {
                return oldItem.aulaId == newItem.aulaId
            }

            override fun areContentsTheSame(oldItem: Aula, newItem: Aula): Boolean {
                return oldItem == newItem
            }
        }
    }


}