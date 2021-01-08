package com.example.wheretoeat.userDatabase

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.launch

@OptIn(InternalCoroutinesApi::class)
class UserViewModel(application: Application) : AndroidViewModel(application) {
    val readData: LiveData<UserDatas>
    private val repository: UserRepository
    val readLoginData: LiveData<List<UserDatas>>

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readData = repository.readAllData
        readLoginData=repository.readLoginData
    }


    fun addUser(user: UserDatas){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }

    fun updateUser(user: UserDatas){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }
}