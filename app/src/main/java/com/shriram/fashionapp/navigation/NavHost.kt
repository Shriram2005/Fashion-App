package com.shriram.fashionapp.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shriram.fashionapp.screen.CartScreen
import com.shriram.fashionapp.screen.GetStartedScreen
import com.shriram.fashionapp.screen.HomeScreen
import com.shriram.fashionapp.screen.LoginScreen
import com.shriram.fashionapp.screen.ProfileScreen
import com.shriram.fashionapp.screen.RegisterScreen
import com.shriram.fashionapp.screen.WishListScreen


sealed class Screen(
    val route: String,
    val title: (String)? = null,
    val icon: (ImageVector)? = null,
    val selectedIcon: (ImageVector)? = null
) {
    data object GetStarted : Screen("GetStarted")
    data object Login : Screen("Login")
    data object Register : Screen("Register")
    data object Home : Screen("Home", "Home", Icons.Outlined.Home, Icons.Filled.Home)

    data object WishList :
        Screen("WishList", "WishList", Icons.Outlined.FavoriteBorder, Icons.Filled.Favorite)
    data object Profile : Screen("Profile", "Profile", Icons.Outlined.Person, Icons.Filled.Person)
    data object Cart : Screen("Cart", "Cart", Icons.Outlined.AccountBox, Icons.Filled.AccountBox)
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.GetStarted.route) {
        composable(route = Screen.GetStarted.route) { GetStartedScreen(navController = navController) }
        composable(route = Screen.Login.route) { LoginScreen(navController = navController) }
        composable(route = Screen.Register.route) { RegisterScreen(navController = navController) }
        composable(route = Screen.Home.route) { HomeScreen(navController = navController) }

        composable(route = Screen.WishList.route) { WishListScreen(navController = navController) }
        composable(route = Screen.Profile.route) { ProfileScreen(navController = navController) }
        composable(route = Screen.Cart.route) { CartScreen(navController = navController) }
    }
}