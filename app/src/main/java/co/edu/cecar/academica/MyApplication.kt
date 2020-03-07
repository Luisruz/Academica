package co.edu.cecar.academica

import android.app.Application
import co.edu.cecar.academica.presentation.di.appModule
import co.edu.cecar.academica.presentation.di.databaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // start Koin!
        startKoin {
            // declare used Android context
            androidContext(this@MyApplication)
            // declare modules
            modules(appModule, databaseModule)
        }
    }
}