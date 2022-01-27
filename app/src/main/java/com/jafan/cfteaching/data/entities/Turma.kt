package com.jafan.cfteaching.data.entities



data class Turma(
    val id: Long,
    val nomeTurma: String,
    val curso: String,
    val ativo: Boolean,
    val alunos: List<Aluno>
)