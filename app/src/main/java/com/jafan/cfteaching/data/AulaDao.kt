package com.jafan.cfteaching.data

import androidx.room.*
import com.jafan.cfteaching.data.entities.Aula


@Dao
interface AulaDao {

    //@Query("SELECT * FROM aulas_alunos WHERE alunoId = :alunoId AND aulaId = :aulaId")
    // fun getAulaDeAluno(alunoId: long, aulaId: String)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(aula: Aula)

    @Update
    suspend fun update(aula: Aula)

    @Delete
    suspend fun delete(aula: Aula)
}