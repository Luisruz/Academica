package co.edu.cecar.academica.data

import co.edu.cecar.academica.data.db.AppDatabase
import co.edu.cecar.academica.data.db.entity.StudentEntity
import co.edu.cecar.academica.data.network.RetrofitClient
import co.edu.cecar.academica.data.network.StudentApi
import co.edu.cecar.academica.domain.StudentRepository
import co.edu.cecar.academica.presentation.model.Student
import io.reactivex.Observable

class StudentRepositoryImpl(val database: AppDatabase) : StudentRepository {

    val studentApi = RetrofitClient()
        .getRetrofitClient()
        .create(StudentApi::class.java)

    override fun getStubStudent(): Observable<List<Student>> {
        /*val students = arrayListOf<Student>()
        students.add(
            Student(1, "Juan")
        )
        students.add(
            Student(2, "Andres")
        )
        return students*/

        return studentApi.getStudents()
            .map {
                //insert varios registros
                /*  val entities = it.map {
                      StudentEntity(it.id, it.name)
                  }
                  insertStudents(entities)
                  it*/
                it.map {
                    //val student = it.first()
                    val entity = StudentEntity(it.id, it.name)
                    //insert un registro en db
                    //Verificar si el primer valor es nulo
                    //val student = it.firstOrNull()
                    //val entity = StudentEntity(student?.id!!,student.name)
                    insertStudent(entity)
                    it
                }
            }

    }

    override fun insertStudent(student: StudentEntity) {
        database.studentDao().insertAll(student)

    }

    override fun insertStudents(students: List<StudentEntity>) {
        database.studentDao().insertAll(*students.toTypedArray())
    }

    override fun getStudentsForLocalDatabase(): Observable<List<StudentEntity>> {
        return database.studentDao().getStudent()
    }

}