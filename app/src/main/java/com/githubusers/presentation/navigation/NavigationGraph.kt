package com.githubusers.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.githubusers.presentation.screens.users.UsersScreen
import com.githubusers.presentation.screens.info.UserDetailsScreen

@Composable
fun NavigationGraph(navController: NavHostController, innerPadding: PaddingValues) {
    NavHost(
        modifier = Modifier.padding(innerPadding),
        navController = navController,
        startDestination = Screen.Users.route
    ) {
        composable(route = Screen.Users.route) {
            UsersScreen(navController = navController)
        }
        composable(
            route = "${Screen.UserDetails.route}/{$USER_LOGIN_ARGUMENT}",
            arguments = listOf(navArgument(USER_LOGIN_ARGUMENT) { type = NavType.StringType })
        ) { entry ->
            val userLogin: String = entry.arguments?.getString(USER_LOGIN_ARGUMENT) ?: ""
            UserDetailsScreen(navController = navController, userLogin)
        }
    }
}

const val USER_LOGIN_ARGUMENT = "USER_LOGIN";