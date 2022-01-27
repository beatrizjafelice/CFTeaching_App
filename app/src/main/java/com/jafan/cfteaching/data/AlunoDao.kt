package com.jafan.cfteaching.data

import androidx.room.*
import com.jafan.cfteaching.data.entities.Aluno
import kotlinx.coroutines.flow.Flow

@Dao
interface AlunoDao {

    /*@Query("SELECT * FROM alunos ORDER BY nome")
    fun getAlunos(): Flow<List<Aluno>>

    @Query("SELECT * FROM alunos WHERE id = :id")
    fun getAlunoById(id: Int): Flow<Aluno>*/

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(aluno: Aluno)

    @Update
    suspend fun update(aluno: Aluno)

    @Delete
    suspend fun delete(aluno: Aluno)
}