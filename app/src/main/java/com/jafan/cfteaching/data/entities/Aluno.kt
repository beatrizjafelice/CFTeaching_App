package com.jafan.cfteaching.data.entities



data class Aluno(
    val id: Long,
    val nome: String,
    val curso: String,
    val ativo: Boolean,
    val telefone: String,
    val valorHora: Double,
    var turma: Turma?
)