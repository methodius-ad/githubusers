package com.composemvimonolithtemplate.presentation.screens.info

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.composemvimonolithtemplate.domain.model.InfoData
import com.composemvimonolithtemplate.presentation.theme.Loading
import org.koin.androidx.compose.koinViewModel

@Composable
fun InfoScreen(navController: NavController) {
    val viewModel = koinViewModel<InfoScreenViewModel>()
    val screenState = viewModel.screenState.collectAsState()

    screenState.value.infoData?.let { infoData ->
        ShowInfoData(
            infoData = infoData,
            onBackClick = { navController.popBackStack() }
        )
    } ?: Loading()
}

@Composable
private fun ShowInfoData(infoData: InfoData, onBackClick: () -> Unit) {
    Box {
        IconButton(onClick = onBackClick) {
            Image(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                colorFilter = ColorFilter.tint(color = Color.Green)
            )
        }
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = infoData.title,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}