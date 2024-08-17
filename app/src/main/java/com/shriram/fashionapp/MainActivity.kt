package com.shriram.fashionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.shriram.fashionapp.navigation.BottomNavigationBar
import com.shriram.fashionapp.navigation.NavigationGraph
import com.shriram.fashionapp.navigation.Screen
import com.shriram.fashionapp.ui.theme.FashionAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set black or white status bar icons  // true = black
//        WindowCompat.getInsetsController(window,window.decorView).isAppearanceLightStatusBars = true

        enableEdgeToEdge()
        setContent {
            FashionAppTheme {
                MyApp()
            }
        }
    }
}

@Preview
@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            if (currentRoute(navController) in listOf(
                    Screen.Home.route,
                    Screen.Profile.route,
                    Screen.WishList.route,
                    Screen.Cart.route
                )
            ) {
                BottomNavigationBar(navController)
            }
        }
    ) { innerPadding ->
        NavigationGraph(navController = navController)
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}




