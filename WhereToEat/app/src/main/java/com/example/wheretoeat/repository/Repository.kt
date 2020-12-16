package com.example.wheretoeat.repository

import com.example.wheretoeat.api.utils.RetrofitInstance
import com.example.wheretoeat.model.Post

class Repository {

    suspend fun  getPost(): Post {
        return RetrofitInstance.api.getPost()
    }


}