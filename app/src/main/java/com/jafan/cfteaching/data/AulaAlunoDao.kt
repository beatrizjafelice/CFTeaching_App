package com.jafan.cfteaching.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.jafan.cfteaching.data.entities.AulaAlunoCrossRef

@Dao
interface AulaAlunoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(aulaAluno: AulaAlunoCrossRef)
}