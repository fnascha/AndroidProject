package com.example.wheretoeat.model

import com.google.gson.annotations.SerializedName

data class Post (
        val userId: Int,
        val cities: String,
        val restaurants: String

        )