package com.jafan.cfteaching.data.relations

import com.jafan.cfteaching.data.entities.Aluno
import com.jafan.cfteaching.data.entities.Aula

data class AulaComAlunos (
        // @Embedded
        val aula: Aula,
        // @Relation (
        // parentColumn = "aulaId"
        // entityColumn = "alunoId"
        val alunos: List<Aluno>
        )