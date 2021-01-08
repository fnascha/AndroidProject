package com.example.wheretoeat.repository

import com.example.wheretoeat.api.utils.RetrofitInstance
import com.example.wheretoeat.model.ApiResponse
import com.example.wheretoeat.model.Post
import com.example.wheretoeat.model.Restaurants
import retrofit2.Response


class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }

    suspend fun getPostRest(nameCity: String): Response<Post> {
        return RetrofitInstance.api.getPostRest(nameCity)
    }

    suspend fun getPostRest2(options: Map<String, String>): Response<ApiResponse> {
        return RetrofitInstance.api.getPostRest2(options)
    }


}