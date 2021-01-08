package com.example.wheretoeat.model



data class ApiResponse (
        val total_entries: Int,
        val per_page: Int,
        val current_page: Int,
        val restaurants: List<Restaurants>
)



class Restaurants(
    val id: Int,
    val nameRes: String,
    val addressRes: String,
    val city: String,
    val state: String,
    val area: String,
    val postal_code: Int,
    val country: String,
    val phoneRes: String,
    val lat: Double,
    val lng: Double,
    val price: Int,
    val reserve_url: String,
    val mobile_reserve_url: String,
    val image_url: String
)