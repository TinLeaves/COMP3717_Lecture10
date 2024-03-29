package com.bcit.lecture10.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class LocalUser(

    @PrimaryKey(autoGenerate = true) val uid: Int? = null,
    //camelcase for variables in kotlin and column info for whatever we want in database
    @ColumnInfo(name = "user_name") val userName: String?,
    val email: String?
)