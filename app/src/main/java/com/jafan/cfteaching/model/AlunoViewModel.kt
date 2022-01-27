package com.jafan.cfteaching.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jafan.cfteaching.data.AlunoDao
import com.jafan.cfteaching.data.entities.Aluno
import com.jafan.cfteaching.data.entities.Turma
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class AlunoViewModel(private val alunoDao: AlunoDao): ViewModel() {

    //val allAlunos: LiveData<List<Aluno>> = alunoDao.getAlunos()

    private fun insertAluno(aluno: Aluno) {
        viewModelScope.launch {
            alunoDao.insert(aluno)
        }
    }

    private fun updateAluno(aluno: Aluno) {
        viewModelScope.launch {
            alunoDao.update(aluno)
        }
    }

    private fun deleteAluno(aluno: Aluno) {
        viewModelScope.launch {
            alunoDao.delete(aluno)
        }
    }

   // fun buscaAlunoPorId(id: Long): LiveData<Aluno> {
        //return alunoDao.getAlunoById(id).asLiveData()
   // }

    fun salvaNovoAluno(
        id: Long,
        nome: String,
        telefone: String,
        curso: String,
        ativo: Boolean,
        valorHora: Double,
        ) {

        val novoAluno = Aluno (
            id = id,
            nome = nome,
            telefone = telefone,
            curso = curso,
            ativo = ativo,
            valorHora = valorHora,
            turma = null
                )

        insertAluno(novoAluno)

    }

    fun atualizaAluno(
        id: Long,
        nome: String,
        telefone: String,
        curso: String,
        ativo: Boolean,
        valorHora: Double
    ) {

        val alunoAtualizado = Aluno (
            id = id,
            nome = nome,
            telefone = telefone,
            curso = curso,
            ativo = ativo,
            valorHora = valorHora,
            turma = null
        )

        updateAluno(alunoAtualizado)

    }

    fun alunoTemTurma(aluno: Aluno): Boolean {
        return aluno.turma != null
    }

    fun addAlunoATurma(aluno: Aluno, turma: Turma) {
        val alunoComTurma = aluno.copy(turma = turma)
        updateAluno(alunoComTurma)
    }



}

class AlunoViewModelFactory(private val alunoDao: AlunoDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AlunoViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AlunoViewModel(alunoDao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}