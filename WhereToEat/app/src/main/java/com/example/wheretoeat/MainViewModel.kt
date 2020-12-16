package com.example.wheretoeat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat.model.Post
import com.example.wheretoeat.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Post> = MutableLiveData()


    fun getPost()
    {
        viewModelScope.launch {
        val response = repository.getPost()
        myResponse.value = response

        }
    }


}