package il.co.solvi.roompracticepl.data.local

import androidx.room.*
import il.co.solvi.roompracticepl.data.entities.Director
import il.co.solvi.roompracticepl.data.entities.School
import il.co.solvi.roompracticepl.data.entities.Student
import il.co.solvi.roompracticepl.data.entities.Subject
import il.co.solvi.roompracticepl.data.local.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    // Transaction is for thread safety
    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName: String) : List<SchoolAndDirector>


    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolWithStudents(schoolName: String) : List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subjectName =:subjectName ")
    suspend fun getStudentsOfSubject(subjectName: String) : List<SubjectWithStudents>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studentName")
    suspend fun getSubjectsOfStudent(studentName: String) : List<StudentWithSubjects>


}