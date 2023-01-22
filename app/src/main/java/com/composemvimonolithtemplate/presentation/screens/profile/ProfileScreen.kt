package com.composemvimonolithtemplate.presentation.screens.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.composemvimonolithtemplate.domain.model.UserInfo
import com.composemvimonolithtemplate.presentation.theme.Loading
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(navController: NavController) {
    val viewModel = koinViewModel<ProfileViewModel>()

    when (val screenState = viewModel.screenState.collectAsState().value) {
        is ProfileScreenState.Loading -> Loading()
        is ProfileScreenState.ShowUserInfo -> ShowUserInfo(
            userInfo = screenState.userInfo,
            onUpdateUserInfoClick = { viewModel.handleEvent(ProfileScreenEvent.UpdateUserInfo) }
        )
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ShowUserInfo(userInfo: UserInfo, onUpdateUserInfoClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 16.dp, end = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        GlideImage(
            modifier = Modifier.size(300.dp),
            model = userInfo.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Name: ${userInfo.name}",
            fontSize = 18.sp
        )
        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Email: ${userInfo.email}",
            fontSize = 18.sp
        )
        Button(
            modifier = Modifier.padding(top = 16.dp),
            onClick = onUpdateUserInfoClick
        ) {
            Text(text = "Update user info")
        }
    }
}