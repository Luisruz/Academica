package co.edu.cecar.academica.domain

import co.edu.cecar.academica.presentation.model.Student
import io.reactivex.Observable
import org.koin.core.KoinComponent
import org.koin.core.inject

class StundentUseCase: KoinComponent {
    val repository:StudentRepository by inject()
    fun getStubStudent(): Observable<List<Student>> {
        return repository.getStubStudent()
    }
}