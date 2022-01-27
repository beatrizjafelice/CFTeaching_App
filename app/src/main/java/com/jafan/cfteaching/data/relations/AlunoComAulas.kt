package com.jafan.cfteaching.data.relations

import com.jafan.cfteaching.data.entities.Aluno
import com.jafan.cfteaching.data.entities.Aula

data class AlunoComAulas (
    //@Embedded
    val aluno: Aluno,
    // @Relation (
    // parentColumn = "alunoId",
    // entity column = "aulaId",
    // associateBy = Junction(AulaAlunoCrossRef::class)
    val aulas: List<Aula>
        )
