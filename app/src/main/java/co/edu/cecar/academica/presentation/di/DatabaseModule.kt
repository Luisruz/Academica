package co.edu.cecar.academica.presentation.di

import androidx.room.Room
import co.edu.cecar.academica.data.db.AppDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, "academia"
        ).build()
    }
}