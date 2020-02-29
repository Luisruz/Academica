package co.edu.cecar.academica.domain

import co.edu.cecar.academica.data.StudentRepositoryImpl
import co.edu.cecar.academica.presentation.model.Student
import io.reactivex.Observable

class StundentUseCase ( val studentRepository: StudentRepository) {
    fun getStubStudent(): Observable<List<Student>> {
        return studentRepository.getStubStudent()
    }
}