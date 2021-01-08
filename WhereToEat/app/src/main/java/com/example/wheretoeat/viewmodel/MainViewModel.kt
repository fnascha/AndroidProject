package com.example.wheretoeat.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wheretoeat.model.ApiResponse
import com.example.wheretoeat.model.Post
import com.example.wheretoeat.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    var myResponse: MutableLiveData<Response<Post>> = MutableLiveData()
    var myResponseRest: MutableLiveData<Response<Post>> = MutableLiveData()

    /*
    var myCustomPosts: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    var myCustomPosts2: MutableLiveData<Response<List<Post>>> = MutableLiveData()
    */

    var myResponseRest2: MutableLiveData<Response<ApiResponse>> = MutableLiveData()

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

    fun getPostRest2(options: Map<String,String>) {
        viewModelScope.launch {
            val response = repository.getPostRest2(options)
            myResponseRest2.value = response
        }
    }


}