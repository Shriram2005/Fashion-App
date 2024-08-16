package com.shriram.fashionapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.shriram.fashionapp.navigation.NavigationGraph
import com.shriram.fashionapp.screen.GetStartedScreen
import com.shriram.fashionapp.screen.LoginScreen
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
    NavigationGraph(navController = navController)
}