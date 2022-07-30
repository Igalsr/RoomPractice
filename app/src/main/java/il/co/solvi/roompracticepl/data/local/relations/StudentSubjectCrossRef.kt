package il.co.solvi.roompracticepl.data.local.relations

import androidx.room.Entity

// Because this is a cross ref its marked as Entity and given 2 primary keys
@Entity(primaryKeys = ["studentName", "subjectName"])
data class StudentSubjectCrossRef(
    val studentName: String,
    val subjectName: String
) {
}