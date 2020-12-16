package com.example.wheretoeat.api

import com.example.wheretoeat.model.Post
import retrofit2.Response
import retrofit2.http.GET



interface SimpleApi {

    @GET("/cities")
    suspend fun getPost(): Response<Post>

}