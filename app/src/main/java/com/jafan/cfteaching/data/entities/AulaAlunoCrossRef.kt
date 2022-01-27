package com.jafan.cfteaching.data.entities

// @Entity(primaryKeys=[aulaId, alunoId])
data class AulaAlunoCrossRef (
    val aulaId: String,
    val alunoId: Long
)