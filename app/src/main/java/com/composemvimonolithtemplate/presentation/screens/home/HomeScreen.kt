package com.composemvimonolithtemplate.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.composemvimonolithtemplate.domain.model.HomeData
import com.composemvimonolithtemplate.presentation.navigation.Screen
import com.composemvimonolithtemplate.presentation.theme.Loading
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = koinViewModel<HomeViewModel>()

    when (val screenState = viewModel.screenState.collectAsState().value) {
        is HomeScreenState.Loading -> Loading()
        is HomeScreenState.ShowHomeData -> ShowHomeData(
            homeData = screenState.homeData,
            onShowInfoScreenClick = { navController.navigate(Screen.Info.route) }
        )
    }
}

@Composable
private fun ShowHomeData(homeData: HomeData, onShowInfoScreenClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = homeData.title,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Button(onClick = onShowInfoScreenClick) {
            Text(text = "Show Info Screen")
        }
    }
}