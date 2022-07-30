package il.co.solvi.roompracticepl.data.local.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import il.co.solvi.roompracticepl.data.entities.Student
import il.co.solvi.roompracticepl.data.entities.Subject

data class StudentWithSubjects(

    @Embedded
    val student: Student,

    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects: List<Subject>

)

/*
Embedded-
Can be used as an annotation on a field of an Entity or Pojo to signal that nested fields
(i.e. fields of the annotated field's class) can be referenced directly in the SQL queries.

Example
 public class Coordinates {
       double latitude;
       double longitude;
   }
   public class Address {
       String street;
       @Embedded
       Coordinates coordinates;
   }

   Room will consider latitude and longitude as if they are fields
   of the Address class when mapping an SQLite row to Address.
 */