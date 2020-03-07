package co.edu.cecar.academica.domain

import co.edu.cecar.academica.data.db.entity.StudentEntity
import co.edu.cecar.academica.presentation.model.Student
import io.reactivex.Observable

interface StudentRepository {
    fun getStubStudent(): Observable<List<Student>>
    fun insertStudent(student: StudentEntity)
    fun insertStudents(students: List<StudentEntity>)
    fun getStudentsForLocalDatabase(): Observable<List<StudentEntity>>
}