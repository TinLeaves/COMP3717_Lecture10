package com.bcit.lecture10.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
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
        CustomTextField(label = "uid", value = signupState.uid, onValueChanged = signupState.onUidChanged, valid = signupState.validUid)
        CustomTextField(label = "username", value = signupState.username, onValueChanged = signupState.onUsernameChanged)
        CustomTextField(label = "email", value = signupState.email, onValueChanged = signupState.onEmailChanged, valid = signupState.validEmail)
        Spacer(modifier = Modifier.height(30.dp))
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()){
            Button(
                onClick = { userState.add(LocalUser(userName = signupState.username, email = signupState.email)) }
            ) {
                Text(text = "Add", fontSize = 36.sp)
            }
            Button(
                onClick = { userState.refresh() }
            ) {
                Text(text = "Refresh", fontSize = 36.sp)
            }
        }
        Spacer(modifier = Modifier.height(30.dp))
        LazyColumn {
            items(userState.users) { user ->
                UserItem(user = user, onDeleteClicked = { userState.deleteUser(user) })
            }
        }
    }
}

@Composable
fun CustomTextField(
    label: String,
    value: String,
    onValueChanged: (String) -> Unit,
    valid: Boolean = true
) {
    Column {
        Row(verticalAlignment = Alignment.CenterVertically)  {
            Text(
                text = "$label:",
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(horizontal = 20.dp)
            )
        }
        Row(verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = value,
                onValueChange = onValueChanged,
                textStyle = TextStyle(fontSize = 30.sp),
                label = null,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}

@Composable
fun UserItem(user: LocalUser, onDeleteClicked: () -> Unit) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = user.userName ?: "",
                fontSize = 16.sp,
            )
            Text(
                text = user.email ?: "",
                fontSize = 16.sp,
            )
            IconButton(onClick = onDeleteClicked) {
                Icon(
                    imageVector = Icons.Default.Clear,
                    contentDescription = "Delete",
                    tint = Color.Black
                )
            }
        }
    }
}