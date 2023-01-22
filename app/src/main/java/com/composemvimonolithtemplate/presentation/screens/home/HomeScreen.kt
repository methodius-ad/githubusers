package com.composemvimonolithtemplate.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = koinViewModel<HomeViewModel>()
}