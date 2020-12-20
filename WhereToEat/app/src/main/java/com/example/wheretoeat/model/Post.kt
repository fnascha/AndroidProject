package com.example.wheretoeat.model

data class Post (
        val restaurants: List<Restaurants>,
        val cities : Array<String>
        ) {
}