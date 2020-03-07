package co.edu.cecar.academica.presentation.di

import co.edu.cecar.academica.data.StudentRepositoryImpl
import co.edu.cecar.academica.data.network.StudentRepositoryMysqlImp
import co.edu.cecar.academica.domain.StudentRepository
import org.koin.dsl.module

val appModule = module {
    factory<StudentRepository> {
        StudentRepositoryImpl()
    }
}