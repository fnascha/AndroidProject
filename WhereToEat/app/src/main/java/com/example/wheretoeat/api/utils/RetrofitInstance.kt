package com.example.wheretoeat.api.utils

import com.example.wheretoeat.api.SimpleApi
import com.example.wheretoeat.api.utils.Constans.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitInstance {

    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val api: SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)


    }

}