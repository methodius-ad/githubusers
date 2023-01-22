package com.composemvimonolithtemplate.presentation.screens.profile

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(navController: NavController) {
    val viewModel = koinViewModel<ProfileViewModel>()
}