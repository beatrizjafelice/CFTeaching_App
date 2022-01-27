package com.jafan.cfteaching.data

import androidx.room.*
import com.jafan.cfteaching.data.entities.Turma
import com.jafan.cfteaching.data.relations.TurmaComAlunos
import kotlinx.coroutines.flow.Flow

@Dao
interface TurmaDao {

    /*@Query("SELECT * FROM turmas ORDER BY nome_turma")
    fun getTurmas(): Flow<List<Turma>>

    @Query("SELECT * FROM turmas WHERE id = :id")
    fun getTurmaById(id: Int): Flow<Turma>

    @Query("SELECT alunos_turma FROM turmas WHERE id = :id")
    fun getAlunosTurma(id: Int): Flow<List<Aluno>>*/

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(turma: Turma)

    @Update
    suspend fun update(turma: Turma)

    @Delete
    suspend fun delete(turma: Turma)

    @Transaction
    //@Query("SELECT * FROM turmas WHERE id = :turmaId")
    suspend fun getTurmaComAlunos(turmaId: Long): Flow<List<TurmaComAlunos>>
}