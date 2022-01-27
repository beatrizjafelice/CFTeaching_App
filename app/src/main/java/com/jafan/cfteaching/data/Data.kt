package com.jafan.cfteaching.data

import com.jafan.cfteaching.data.entities.Aluno
import com.jafan.cfteaching.data.entities.Turma


val lista_alunos = listOf(
    Aluno(0, "Leandro","presencial", true, "(11) 9555-5555", 60.0,null),
    Aluno(1, "Emily", "online", true, "(11) 9555-5555", 50.0,null),
    Aluno(2, "Fabio", "presencial", true, "(11) 9555-5555", 50.0,null),
    Aluno(3, "Ricardo", "presencial", true, "(11) 9555-5555", 50.0,null),
    Aluno(4, "Nathalia", "presencial", true, "(11) 9555-5555", 48.0,null)
)

val lista_turmas = listOf(
    Turma(1, "Scorpios", "presencial", true, listOf(lista_alunos[2], lista_alunos[3]))
)






