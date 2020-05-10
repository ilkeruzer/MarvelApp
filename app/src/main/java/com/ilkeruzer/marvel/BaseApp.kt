package com.ilkeruzer.marvel

import android.app.Application
import com.ilkeruzer.marvel.di.appModule
import com.ilkeruzer.marvel.di.networkModule
import com.ilkeruzer.marvel.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Created by İlker Üzer on 8.05.2020.
 */

class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@BaseApp)
            modules(listOf(
                appModule,
                networkModule,
                viewModelModule
            ))
        }


    }
}