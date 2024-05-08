package com.example.tubesmypathai

import MainPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.example.tubesmypathai.ui.theme.Material3ComposeTheme
import android.view.WindowManager
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE)
        setContent {
            Material3ComposeTheme {
                LoginApplication()
            }
        }
    }

    @OptIn(ExperimentalComposeUiApi::class)
    @Composable
    fun LoginApplication(){
        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "login_page", builder = {
            composable("login_page", content = { LoginPage(navController = navController) })
            composable("register_page", content = { RegisterPage(navController = navController) })
            composable("reset_page", content = { ResetPage(navController = navController) })
            composable("main_page", content = { MainPage(navController = navController) })


        })
    }
}