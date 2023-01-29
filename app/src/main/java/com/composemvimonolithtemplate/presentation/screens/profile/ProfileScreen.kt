package com.composemvimonolithtemplate.presentation.screens.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.composemvimonolithtemplate.domain.model.ProfileData
import com.composemvimonolithtemplate.presentation.theme.Loading
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen() {
    val viewModel = koinViewModel<ProfileViewModel>()
    val screenState = viewModel.screenState.collectAsState()

    screenState.value.profileData?.let { profileData ->
        ShowProfileData(profileData = profileData)
    } ?: Loading()
}

@Composable
private fun ShowProfileData(profileData: ProfileData) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = profileData.title,
            fontSize = 18.sp,
            textAlign = TextAlign.Center
        )
    }
}