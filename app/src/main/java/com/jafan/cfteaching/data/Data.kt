package com.jafan.cfteaching.data


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

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
    val precoMes: Double,

)


data class Turma(
    val id: Int,
    val nomeTurma: String,
    val alunosTurma: List<Aluno>,
    val valor: Double
)

val lista_alunos = listOf(
    Aluno(0, "Leandro", 10.0),
    Aluno(1, "Maria", 30.0),
    Aluno(2, "Lucas", 50.0),
    Aluno(3, "Andrea", 25.0),
    Aluno(4, "José", 32.0)
)

val lista_turmas = listOf(
    Turma(0, "Turma 1", listOf(lista_alunos[0], lista_alunos[1]), 60.0),
    Turma(1, "Turma 2", listOf(lista_alunos[2]), 80.0),
    Turma(2, "Turma 3", listOf(lista_alunos[3]), 40.0),
    Turma(3, "Turma 4", listOf(lista_alunos[4]),60.0)
)




