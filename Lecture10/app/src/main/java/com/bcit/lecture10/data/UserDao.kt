package com.bcit.lecture10.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table")
    fun getAll(): List<LocalUser>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: LocalUser)

    @Delete
    fun delete(user: LocalUser)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun replace(user: LocalUser)
}