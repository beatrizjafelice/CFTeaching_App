package com.jafan.cfteaching.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface TurmaDao {

    /*@Query("SELECT * FROM turmas ORDER BY nome_turma")
    fun getTurmas(): Flow<List<Turma>>

    @Query("SELECT * FROM turmas WHERE id = :id")
    fun getTurmaById(id: Int): Flow<Turma>*/

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(turma: Turma)

    @Update
    suspend fun update(turma: Turma)

    @Delete
    suspend fun delete(turma: Turma)
}