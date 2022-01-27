package com.jafan.cfteaching.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.jafan.cfteaching.data.TurmaDao
import com.jafan.cfteaching.data.entities.Turma
import kotlinx.coroutines.launch

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

    private fun deleteTurma(turma: Turma) {
        viewModelScope.launch {
            turmaDao.delete(turma)
        }
    }

    //fun buscaTurmaPorId(id: Int): LiveData<Turma> {
        //return turmaDao.getTurmaById(id)
    //}

 /*   fun salvaNovaTurma(id: Long, nomeTurma: String) {
        val novaTurma = Turma(id = id, nomeTurma = nomeTurma)
        insertTurma(novaTurma)

    }

    fun atualizaTurma(id: Long, nomeTurma: String) {
        val turmaAtualizada = Turma(id = id, nomeTurma = nomeTurma)
        updateTurma(turmaAtualizada)
    }
*/


    fun turmaValida(nomeTurma: String): Boolean {
        return nomeTurma.isNotBlank()
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