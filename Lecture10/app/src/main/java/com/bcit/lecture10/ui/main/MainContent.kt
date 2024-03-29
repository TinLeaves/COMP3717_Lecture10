package com.bcit.lecture10.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcit.lecture10.data.LocalUser

@Composable
fun MainContent(userState: UserState){

    val signupState = remember {
        SignupState()
    }


    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){
        Spacer(modifier = Modifier.height(20.dp))
        MyTextField("username", signupState.username, signupState.onUsernameChanged)
        MyTextField(
            "email",
            signupState.email,
            signupState.onEmailChanged,
            signupState.validEmail
        )
        Spacer(modifier = Modifier.height(10.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
            Button(onClick = { userState.add(LocalUser(userName = signupState.username, email = signupState.email)) }) {
                Text(text = "Add")
            }
            Button(onClick = { userState.refresh() }) {
                Text(text = "Refresh")
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn{
            items(userState.users.size){
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                    Text(text = userState.users[it].userName!!, fontSize = 20.sp)
                    Text(text = userState.users[it].email!!, fontSize = 20.sp)
                }
            }
        }
    }
}

@Composable
fun MyTextField(
    label:String,
    value: String,
    onValueChanged: (String)-> Unit,
    valid:Boolean = true
){

    Column {
        TextField(
            value = value,
            onValueChange = onValueChanged,
            textStyle = TextStyle(fontSize = 30.sp),
            label = {
                Text(label)
            }
        )
        if (!valid) Text(text = "Not valid")
    }
}

