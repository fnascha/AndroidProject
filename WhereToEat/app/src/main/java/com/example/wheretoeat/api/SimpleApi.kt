package com.example.wheretoeat.api

import com.example.wheretoeat.model.ApiResponse
import com.example.wheretoeat.model.Post
import com.example.wheretoeat.model.Restaurants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap


interface SimpleApi {


    @GET("cities")
    suspend fun getPost(): Response<Post>

    @GET("restaurants/{postName}")
    suspend fun getPostRest(
        @Query("city") city: String
    ):Response<Post>



    @GET("restaurants")
    suspend fun getPostRest2(
            @QueryMap options: Map<String, String>
    ):Response<ApiResponse>




}