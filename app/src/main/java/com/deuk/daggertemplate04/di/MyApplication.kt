package com.deuk.daggertemplate04.di

import android.app.Application

class MyApplication: Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

}