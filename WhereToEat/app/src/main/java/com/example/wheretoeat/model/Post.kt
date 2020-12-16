package com.example.wheretoeat.model

import com.google.gson.annotations.SerializedName

data class Post (
        val userId: Int,
        val id: Int,
        val restaurant: String,
        val body: String
        )