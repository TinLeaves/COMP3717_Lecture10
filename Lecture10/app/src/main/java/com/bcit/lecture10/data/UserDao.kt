package com.bcit.lecture10.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getAll(): List<LocalUser>

    @Insert
    fun add(user: LocalUser)
}
