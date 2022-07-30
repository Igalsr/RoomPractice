package il.co.solvi.roompracticepl.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import il.co.solvi.roompracticepl.data.entities.Director
import il.co.solvi.roompracticepl.data.entities.School
import il.co.solvi.roompracticepl.data.entities.Student
import il.co.solvi.roompracticepl.data.entities.Subject
import il.co.solvi.roompracticepl.data.local.relations.StudentSubjectCrossRef


@Database(
    entities = [
        School::class,
        Director :: class,
        Student::class,
        Subject::class,
        StudentSubjectCrossRef :: class
    ],
    version = 1
)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao: SchoolDao

    // singleton
    companion object {

        // to prevent race condition
        @Volatile
        private var INSTANCE: SchoolDatabase? = null

        fun getInstance(context: Context) : SchoolDatabase {

            synchronized(this){
                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE = it
                }
            }


        }
    }

}