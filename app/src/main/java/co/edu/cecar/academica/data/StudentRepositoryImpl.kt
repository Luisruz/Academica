package co.edu.cecar.academica.data

import co.edu.cecar.academica.data.network.RetrofitClient
import co.edu.cecar.academica.data.network.StudentApi
import co.edu.cecar.academica.domain.StudentRepository
import co.edu.cecar.academica.presentation.model.Student
import io.reactivex.Observable

class StudentRepositoryImpl : StudentRepository {
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
    }
}