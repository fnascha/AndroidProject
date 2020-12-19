package com.example.wheretoeat.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat.model.Post
import com.example.wheretoeat.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    val myResponseRest: MutableLiveData<Response<Post>> = MutableLiveData()


    fun getPost()
    {
        viewModelScope.launch {
        val response = repository.getPost()
        myResponse.value = response

        }
    }

    fun getPostRest(nameRest: String){
            viewModelScope.launch {
                val response = repository.getPostRest(nameRest)
                myResponseRest.value = response
            }

    }
}