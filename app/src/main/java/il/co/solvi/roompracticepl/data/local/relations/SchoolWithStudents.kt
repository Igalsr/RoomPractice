package il.co.solvi.roompracticepl.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import il.co.solvi.roompracticepl.data.entities.School
import il.co.solvi.roompracticepl.data.entities.Student

// 1 to N relationship
data class SchoolWithStudents(
    @Embedded
    val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students : List<Student>
)
