package il.co.solvi.roompracticepl.data.local.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import il.co.solvi.roompracticepl.data.entities.Student
import il.co.solvi.roompracticepl.data.entities.Subject

data class SubjectWithStudents(
    @Embedded
    val subject: Subject,

    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students: List<Student>

)
