package com.composemvimonolithtemplate.presentation.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState

private data class BottomNavigationItem(
    val route: String,
    val title: String,
    val icon: ImageVector
)

private val bottomNavigationItems = listOf(
    BottomNavigationItem(
        route = Screen.Home.route,
        title = "Home",
        icon = Icons.Filled.Home
    ),
    BottomNavigationItem(
        route = Screen.Profile.route,
        title = "Profile",
        icon = Icons.Filled.Person
    )
)

@Composable
fun BottomNavigation(navController: NavController) {
    BottomNavigation {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        bottomNavigationItems.forEach { bottomNavigationItem ->
            BottomNavigationItem(
                icon = { Icon(bottomNavigationItem.icon, contentDescription = null) },
                label = { Text(bottomNavigationItem.title) },
                selected = currentDestination?.hierarchy?.any { navDestination -> navDestination.route == bottomNavigationItem.route } == true,
                onClick = {
                    navController.navigate(bottomNavigationItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}