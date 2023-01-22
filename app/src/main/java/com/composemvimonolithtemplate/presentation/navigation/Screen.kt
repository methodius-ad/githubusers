package com.composemvimonolithtemplate.presentation.navigation

sealed class Screen(val route: String) {
    object Home : Screen(route = "home")
    object Profile : Screen(route = "profile")
    object Info : Screen(route = "info")
}