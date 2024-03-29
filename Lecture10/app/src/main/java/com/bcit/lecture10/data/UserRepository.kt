package com.bcit.lecture10.data

class UserRepository(private val userDao: UserDao) {

    //all business logic goes here

    fun insertEntity(user: LocalUser){
        userDao.add(user)
    }

    fun getAll(): List<LocalUser>{
        return userDao.getAll()
    }
}