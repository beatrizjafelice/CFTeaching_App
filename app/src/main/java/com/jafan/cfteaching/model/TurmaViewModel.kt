package com.jafan.cfteaching.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.*
import com.jafan.cfteaching.data.Aluno
import com.jafan.cfteaching.data.Turma
import com.jafan.cfteaching.data.TurmaDao
import kotlinx.coroutines.launch
import java.lang.IllegalArgumentException

class TurmaViewModel(private val turmaDao: TurmaDao): ViewModel() {

    //val allTurmas: LiveData<List<Turma>> = turmaDao.getTurmas().asLiveData()

    // Database-related functions:
    private fun insertTurma(turma: Turma) {
        viewModelScope.launch {
            turmaDao.insert(turma)
        }
    }

    private fun updateTurma(turma: Turma) {
        viewModelScope.launch {
            turmaDao.update(turma)
        }
    }

    fun deleteTurma(turma: Turma) {
        viewModelScope.launch {
            turmaDao.delete(turma)
        }
    }

    fun salvaNovaTurma(nomeTurma: String, alunosTurma: List<Aluno>) {

    }

}

class TurmaViewModelFactory(private val turmaDao: TurmaDao): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(TurmaViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return TurmaViewModel(turmaDao) as T
        }
        throw IllegalArgumentException("Unknown View Model Class")
    }

}