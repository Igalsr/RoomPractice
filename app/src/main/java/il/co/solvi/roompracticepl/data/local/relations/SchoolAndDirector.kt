package il.co.solvi.roompracticepl.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import il.co.solvi.roompracticepl.data.entities.Director
import il.co.solvi.roompracticepl.data.entities.School


// 1 to 1 relationship
data class SchoolAndDirector(

    @Embedded
    val school: School,

    @Relation(
        // Refers to the school entity
        parentColumn = "schoolName",
        // Refers to director entity
        entityColumn = "schoolName"
    )
    val director: Director
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