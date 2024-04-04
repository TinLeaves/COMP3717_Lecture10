package com.bcit.lecture10.ui.main

import androidx.compose.runtime.toMutableStateList
import com.bcit.lecture10.data.LocalUser
import com.bcit.lecture10.data.UserRepository

class UserState(private val repository: UserRepository) {

    val users = repository.getAll().toMutableStateList()

    fun add(localUser: LocalUser){
        repository.insertEntity(localUser)
    }

    fun deleteUser(user: LocalUser) {
        repository.deleteEntity(user)
        refresh()
    }

    fun refresh(){
        //keeps it within scope
        users.apply{
            clear()
            addAll(repository.getAll())
        }
    }
}