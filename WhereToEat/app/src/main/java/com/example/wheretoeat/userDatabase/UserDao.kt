package com.example.wheretoeat.userDatabase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: UserDatas)

    @Update
    suspend fun updateUser(user: UserDatas)

    @Query("SELECT * FROM user_table")
    fun readUser(): LiveData<UserDatas>

    @Query("SELECT * FROM user_table")
    fun readLoginData(): LiveData<List<UserDatas>>
}