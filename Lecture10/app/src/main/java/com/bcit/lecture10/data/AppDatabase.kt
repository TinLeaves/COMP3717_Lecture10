package com.bcit.lecture10.data

import androidx.room.Database
import androidx.room.RoomDatabase

//abstract because room will generate the definition for us
@Database(entities = [LocalUser::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
}