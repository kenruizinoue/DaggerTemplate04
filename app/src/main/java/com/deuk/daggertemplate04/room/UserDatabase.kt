package com.deuk.daggertemplate04.room

import androidx.room.Database
import androidx.room.RoomDatabase
import javax.inject.Singleton

@Singleton
@Database(version = 1, entities = [User::class])
abstract class UserDatabase(): RoomDatabase() {
    abstract fun getUserDao(): UserDao
}