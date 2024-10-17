package com.example.testapplication.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun TestApplicationNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
){
    NavHost(
        navController = navController,
        startDestination = "home",
        modifier = modifier
    ) {
        composable("home"){
            CheckListScreen({})
        }
        composable("clock"){
            ClockScreen()
        }
    }
}