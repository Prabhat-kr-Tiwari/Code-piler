package com.prabhat.code_piler.ui.theme.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "splash_screen"
    ) {
        composable("splash_screen") {
//            val systemUiController: SystemUiController = rememberSystemUiController()
//            systemUiController.isSystemBarsVisible = false
            SplashScreen(navController = navController)
        }

        // Main Screen
        composable("main_screen") {
            MainContent()
        }
    }
}