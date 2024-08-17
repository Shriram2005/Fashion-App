package com.shriram.fashionapp.navigation

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState


@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.WishList,
        Screen.Profile,
        Screen.Cart
    )
    // Observe the backstack to get the current destination
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Get the current route
    val currentRoute = navBackStackEntry?.destination?.route

    // Update the selectedIndex based on the current route
    val selectedIndex = items.indexOfFirst { it.route == currentRoute }

    NavigationBar(
        modifier = Modifier.height(64.dp),
        containerColor = androidx.compose.ui.graphics.Color.White,
        contentColor = androidx.compose.ui.graphics.Color.Black
    ) {
        items.forEachIndexed { index, screen ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    navController.navigate(screen.route) {
                        // This will prevent multiple copies of the same destination being in the backstack
                        popUpTo(Screen.Home.route) {
                            saveState = true
                        }
                        // Avoid multiple copies of the same screen in the back stack
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    (if (selectedIndex == index) screen.selectedIcon else screen.icon)?.let {
                        Icon(
                            imageVector = it,
                            contentDescription = null,
                            tint = Color.Black
                        )
                    }
                },
//                label = {
//                    Text(text = screen.title)
//                },
                alwaysShowLabel = false
            )
        }
    }
}
