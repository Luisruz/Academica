package co.edu.cecar.academica.data.network

import co.edu.cecar.academica.domain.StudentRepository
import co.edu.cecar.academica.presentation.model.Student
import io.reactivex.Observable

class StudentRepositoryMysqlImp : StudentRepository {
    override fun getStubStudent(): Observable<List<Student>> {
        val student1 = Student(1, "A")
        val student2 = Student(2, "B")
        val student3 = Student(3, "C")
        val student4 = Student(4, "D")
        val students = listOf(student1, student2, student3, student4)
        return Observable.just(students)
    }

}