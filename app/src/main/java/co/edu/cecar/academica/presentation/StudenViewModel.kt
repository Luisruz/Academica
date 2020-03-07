package co.edu.cecar.academica.presentation

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.edu.cecar.academica.data.StudentRepositoryImpl
import co.edu.cecar.academica.domain.StundentUseCase
import co.edu.cecar.academica.presentation.model.Student
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.internal.notifyAll

class StudenViewModel : ViewModel() {
    private val studentUseCase = StundentUseCase()
    var mLiveData = MutableLiveData<List<Student>>()
    fun getStudent() = studentUseCase.getStubStudent()

    fun getStudentWithLiveData() {
        studentUseCase.getStubStudent()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                mLiveData.value = it
            }, {
                val error = it
            })
    }
    fun getStudentForLocalDatabase(){
        studentUseCase.getStudentsForLocalDatabase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                val data = it
            }, {
                val error = it
            })
    }

}

