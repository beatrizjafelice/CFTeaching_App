package com.jafan.cfteaching.data.entities


data class Aula (
    val aulaId: String,
    val dia: Int,
    val mes: Int,
    val ano: Int,
    val diaSemana: String,
    val horarioInicio: String,
    val horarioFim: String,
    val duracao: Int,
    val valor: Double,
    val notas: String?,
    val dada: Boolean
)