package com.example.wheretoeat.repository

import com.example.wheretoeat.api.utils.RetrofitInstance
import com.example.wheretoeat.model.Post
import retrofit2.Response

class Repository {

    suspend fun  getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }


}