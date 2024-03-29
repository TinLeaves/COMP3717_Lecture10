package com.bcit.lecture10

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.remember
import com.bcit.lecture10.ui.main.MainContent
import com.bcit.lecture10.ui.main.UserState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userRepository = (application as MyApp).userRepository

        setContent {

            val userState = remember {
                UserState(userRepository)
            }

            MainContent(userState)
        }
    }
}
