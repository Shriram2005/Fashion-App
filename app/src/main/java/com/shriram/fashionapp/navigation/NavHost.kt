package com.shriram.fashionapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shriram.fashionapp.screen.GetStartedScreen
import com.shriram.fashionapp.screen.LoginScreen
import com.shriram.fashionapp.screen.RegisterScreen


sealed class Screen(val route: String) {
    data object GetStarted : Screen("GetStarted")
    data object Login : Screen("Login")
    data object Register : Screen("Register")
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Login.route) {
        composable(route = Screen.GetStarted.route) { GetStartedScreen(navController = navController) }
        composable(route = Screen.Login.route) { LoginScreen(navController = navController) }
        composable(route = Screen.Register.route) { RegisterScreen(navController = navController) }
    }
}