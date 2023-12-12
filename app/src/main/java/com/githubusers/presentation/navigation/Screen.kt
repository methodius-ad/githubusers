package com.githubusers.presentation.navigation

sealed class Screen(val route: String) {
    object Users : Screen(route = "users")
    object UserDetails : Screen(route = "user_details")
}