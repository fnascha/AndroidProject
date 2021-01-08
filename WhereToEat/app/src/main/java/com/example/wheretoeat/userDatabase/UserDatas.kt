package com.example.wheretoeat.userDatabase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
class UserDatas (
    @PrimaryKey(autoGenerate = true)
    val Id: Int,
    val Name: String,
    val Email: String,
    val Phone: String,
    val password: String
)