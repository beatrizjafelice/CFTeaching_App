package com.jafan.cfteaching.data.relations

import com.jafan.cfteaching.data.entities.Aluno
import com.jafan.cfteaching.data.entities.Turma

data class TurmaComAlunos (
        // @Embedded
        val turma: Turma,
        // @Relation (
        // parentColumn = "turmaId",
        // entityColumn = "turma"
        // )
        val alunos: List<Aluno>
        )
