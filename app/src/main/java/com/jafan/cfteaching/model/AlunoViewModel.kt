package com.jafan.cfteaching.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jafan.cfteaching.data.Aluno
import com.jafan.cfteaching.data.AlunoDao
import kotlinx.coroutines.launch

class AlunoViewModel(private val alunoDao: AlunoDao): ViewModel() {

    //val allAlunos: LiveData<List<Aluno>> = alunoDao.getAlunos()

    fun insertAluno(aluno: Aluno) {
        viewModelScope.launch {
            alunoDao.insert(aluno)
        }
    }

    fun updateAluno(aluno: Aluno) {
        viewModelScope.launch {
            alunoDao.update(aluno)
        }
    }

    fun deleteAluno(aluno: Aluno) {
        viewModelScope.launch {
            alunoDao.delete(aluno)
        }
    }

    fun salvaNovoAluno(
        nome: String,
        telefone: String,
        curso: String,
        ativo: Boolean,
        valorHora: Double,
        duracaoAula: Int,
        aulasMes: Int,
        mes: Int,
        ano: Int) {



    }

}