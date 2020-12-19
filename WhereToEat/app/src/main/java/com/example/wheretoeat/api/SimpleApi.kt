package com.example.wheretoeat.api

import com.example.wheretoeat.model.Post
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface SimpleApi {

    @GET("/cities")
    suspend fun getPost(): Response<Post>

    @GET("/cities/{postName}")
    suspend fun getPostRest(
        @Path("postName") nameRest: String

    ):Response<Post>
}