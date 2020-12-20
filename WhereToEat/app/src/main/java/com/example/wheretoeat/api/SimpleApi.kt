package com.example.wheretoeat.api

import com.example.wheretoeat.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface SimpleApi {

    @GET("/cities")
    suspend fun getPost(): Response<Post>

    @GET("/restaurants/{postName}")
    suspend fun getPostRest(
        @Query("city") city: String
    ):Response<Post>

}