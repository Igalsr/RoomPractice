package il.co.solvi.roompracticepl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope

import il.co.solvi.roompracticepl.data.local.SchoolDatabase
import il.co.solvi.roompracticepl.utils.TestData
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        testDbOperations()

    }

    private fun testDbOperations() {

        val dao = SchoolDatabase.getInstance(this).schoolDao

        lifecycleScope.launch {

            TestData.directors.forEach { dao.insertDirector(it) }
            TestData.schools.forEach { dao.insertSchool(it) }
            TestData.subjects.forEach { dao.insertSubject(it) }
            TestData.students.forEach { dao.insertStudent(it) }
            TestData.studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolName("Kotlin School")
            Log.d(TAG, "testDbOperations: $schoolWithDirector")

            val schoolWithStudents = dao.getSchoolWithStudents("Kotlin School")
        }

    }


}