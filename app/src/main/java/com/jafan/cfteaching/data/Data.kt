package com.jafan.cfteaching.data


import android.icu.util.LocaleData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.coroutines.flow.callbackFlow
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*

/*
@Entity(tableName = "alunos")
data class Aluno(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nome") val nome: String,
    @ColumnInfo(name = "curso") val curso: String,
    @ColumnInfo(name = "telefone") val telefone: String,
    @ColumnInfo(name = "preco_mes") val precoMes: Double,
    @ColumnInfo(name = "tempo_aula") val tempoAula: Int,
    @ColumnInfo(name = "reposicoes") val reposicoes: Int,
    @ColumnInfo(name = "ativo") val ativo: Boolean
    )

@Entity(tableName = "turmas")
data class Turma(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nome_turma") val nomeTurma: String,
    @ColumnInfo(name = "alunos_turma") val alunosTurma: List<Aluno>,
    @ColumnInfo(name = "notas") val anotacoes: String,
    @ColumnInfo(name = "valor") val valor: Double
    )
*/


data class Aluno(
    val id: Int,
    val nome: String,
    val valorHora: Double,
    val tempoAula: Int,
    val aulasMes: Int,
    val valorMes: Double,
    val curso: String,
    val ativo: Boolean,
    val telefone: String,
    val notas: List<Anotacao>?,
    var turma: Turma?,
    val anos: MutableMap<Int, MutableList<Int>>
)


data class Turma(
    val id: Int,
    val nomeTurma: String,
    val alunosTurma: MutableList<Aluno>,
    val valorMes: Double,
    val anos: MutableMap<Int, MutableList<Int>>,
    val notas: List<Anotacao>?
)


data class Anotacao(
    val id: Int,
    val titulo: String,
    val notas: String
)

data class Historico (
    val ano: Int,
    val alunos: List<Aluno>
        )

val lista_alunos = listOf(
    Aluno(0, "Leandro", 60.0, 30, 10, 300.0,"presencial", true, "(11) 9555-5555", null, null, mutableMapOf(2022 to mutableListOf(1))),
    Aluno(1, "Emily", 50.0, 60, 12, 450.0,"online", true, "(11) 9555-5555", null, null, mutableMapOf(2022 to mutableListOf(1))),
    Aluno(2, "Fabio", 50.0, 60, 10, 200.0,"presencial", true, "(11) 9555-5555", null, null, mutableMapOf(2022 to mutableListOf(1))),
    Aluno(3, "Ricardo", 50.0, 60, 10,  675.0,"presencial", true, "(11) 9555-5555", null, null, mutableMapOf(2022 to mutableListOf(1))),
    Aluno(4, "Nathalia", 45.0, 90, 10, 675.0,"presencial", true, "(11) 9555-5555", null, null, mutableMapOf(2022 to mutableListOf(1))),
)

val lista_turmas = listOf(
    Turma(0, "Scorpios", mutableListOf(lista_alunos[2], lista_alunos[3]), 100.0, mutableMapOf(2022 to mutableListOf(1)),null))






