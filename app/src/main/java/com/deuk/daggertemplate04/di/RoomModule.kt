package com.deuk.daggertemplate04.di

import android.content.Context
import androidx.room.Room
import com.deuk.daggertemplate04.room.Repository
import com.deuk.daggertemplate04.room.UserDao
import com.deuk.daggertemplate04.room.UserDatabase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {
    @Provides
    fun provideUserDatabase(context: Context): UserDatabase =
        Room.databaseBuilder(context, UserDatabase::class.java, "db").build()

    @Provides
    fun provideUserDao(userDatabase: UserDatabase): UserDao = userDatabase.getUserDao()

    @Provides
    fun provideRepository(userDao: UserDao): Repository = Repository(userDao)
}