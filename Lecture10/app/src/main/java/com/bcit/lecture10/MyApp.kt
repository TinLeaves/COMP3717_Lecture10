package com.bcit.lecture10

import android.app.Application
import androidx.room.Room
import com.bcit.lecture10.data.AppDatabase
import com.bcit.lecture10.data.UserRepository

class MyApp: Application() {

    //invoke once so wrap in lazy
    private val db by lazy{

        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "my-database")
            .allowMainThreadQueries()
            .build()
    }

    val userRepository by lazy{
        UserRepository(db.userDao())
    }

}