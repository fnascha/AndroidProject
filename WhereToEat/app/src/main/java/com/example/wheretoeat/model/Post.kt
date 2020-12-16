package com.example.wheretoeat.model

import com.example.wheretoeat.api.utils.Restaurants
import com.google.gson.annotations.SerializedName

data class Post (
        val restaurants: List<Restaurants>,
        val cities : Array<String>
        )