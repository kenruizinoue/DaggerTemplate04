package com.deuk.daggertemplate04.room

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(private val userDao: UserDao) {
    fun getUsers(): List<User> {
        return userDao.getUsers()
    }

    fun insertUser(user: User) {
        userDao.insertUser(user)
    }
}