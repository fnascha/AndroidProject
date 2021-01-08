package com.example.wheretoeat.userDatabase

import androidx.lifecycle.LiveData

class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<UserDatas> = userDao.readUser()
    val readLoginData: LiveData<List<UserDatas>> = userDao.readLoginData()


    suspend fun addUser(user: UserDatas){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: UserDatas){
        userDao.updateUser(user)
    }
}