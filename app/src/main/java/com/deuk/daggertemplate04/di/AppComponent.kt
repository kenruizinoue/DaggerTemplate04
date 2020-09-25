package com.deuk.daggertemplate04.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton
import com.deuk.daggertemplate04.MainActivity

@Singleton
@Component(modules = [RoomModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun inject(mainActivity: MainActivity)
}