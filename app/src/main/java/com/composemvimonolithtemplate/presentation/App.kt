package com.composemvimonolithtemplate.presentation

import android.app.Application
import com.composemvimonolithtemplate.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        configureKoin()
    }

    private fun configureKoin() {
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModules)
        }
    }
}