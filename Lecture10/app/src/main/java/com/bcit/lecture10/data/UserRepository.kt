package com.bcit.lecture10.data

class UserRepository(private val userDao: UserDao) {

    //all business logic goes here

    fun insertEntity(user: LocalUser){
        userDao.insert(user)
    }

    fun deleteEntity(user: LocalUser){
        userDao.delete(user)
    }

    fun getAll(): List<LocalUser>{
        return userDao.getAll()
    }
}