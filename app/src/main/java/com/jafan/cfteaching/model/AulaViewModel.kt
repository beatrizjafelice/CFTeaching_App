package com.jafan.cfteaching.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jafan.cfteaching.data.AulaAlunoDao
import com.jafan.cfteaching.data.AulaDao
import com.jafan.cfteaching.data.entities.Aluno
import com.jafan.cfteaching.data.entities.Aula
import com.jafan.cfteaching.data.entities.AulaAlunoCrossRef
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class AulaViewModel(private val aulaDao: AulaDao, private val aulaAlunoDao: AulaAlunoDao): ViewModel() {

    private fun insertAula(aula: Aula, aulaAluno: AulaAlunoCrossRef) {
        viewModelScope.launch {
            aulaDao.insert(aula)
            aulaAlunoDao.insert(aulaAluno)
        }
    }


    private fun updateAula(aula: Aula) {
        viewModelScope.launch {
            aulaDao.update(aula)
        }
    }
    private fun deleteAula(aula: Aula) {
        viewModelScope.launch {
            aulaDao.delete(aula)
        }
    }

    fun addNovaAula(
        aluno: Aluno,
        dia: Int,
        mes: Int,
        ano: Int,
        diaSemana: String,
        horarioInicio: String,
        horarioFim: String,
        notas: String?,
        dada: Boolean
    ) {
        val aulaId = "${aluno.nome.replace(' ', '_')}_${dia}/${mes}/${ano}_${horarioInicio}/${horarioFim}"
        val duracao = aluno.tempoAula
        val valor = (aluno.valorHora * duracao) / 60
        val novaAula = Aula(
            aulaId = aulaId,
            dia = dia,
            mes = mes,
            ano = ano,
            diaSemana = diaSemana,
            horarioInicio = horarioInicio,
            horarioFim = horarioFim,
            duracao = duracao,
            valor = valor,
            notas = notas,
            dada = dada
        )

        insertAula(novaAula, AulaAlunoCrossRef(aulaId, aluno.id))
    }

    fun cancelaAula(aula: Aula) {
        val novaAula = aula.copy(dada = false)
        updateAula(novaAula)
    }




}

class AulaViewModelFactory(private val aulaDao: AulaDao, private val aulaAlunoDao: AulaAlunoDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AulaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AulaViewModel(aulaDao, aulaAlunoDao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}