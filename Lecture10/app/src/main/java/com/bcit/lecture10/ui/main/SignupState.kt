package com.bcit.lecture10.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class SignupState{
    //username
    var username by mutableStateOf("")

    val onUsernameChanged: (String)->Unit = {
        username = it
    }

    //email
    var email by mutableStateOf("")

    val onEmailChanged: (String)->Unit = {
        email = it
        //logic check happens here rather in composable
        validEmail = email.contains("@")
    }
    var validEmail = false
}