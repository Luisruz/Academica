package co.edu.cecar.academica.domain

import co.edu.cecar.academica.presentation.model.Student
import io.reactivex.Observable

interface StudentRepository {
    fun getStubStudent(): Observable<List<Student>>
}