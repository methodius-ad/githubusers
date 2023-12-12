package com.githubusers.presentation.screens.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.githubusers.domain.model.UserDetails
import com.githubusers.presentation.theme.Loading
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun UserDetailsScreen(navController: NavController, userLogin: String?) {
    val viewModel = koinViewModel<UserDetailsScreenViewModel>() {
        parametersOf(userLogin)
    }
    val screenState = viewModel.screenState.collectAsState()

    screenState.value.infoData?.let { userDetails ->
        ShowInfoData(
            userDetails = userDetails,
            onBackClick = { navController.popBackStack() },
            onSaveClick = { isSaved, selectedUserId ->
                viewModel.handleEvent(
                    UserDetailsScreenEvent.ChangeUserStarStatus(
                        isSaved,
                        selectedUserId
                    )
                )
            }
        )
    } ?: Loading()
}

@Composable
private fun ShowInfoData(
    userDetails: UserDetails,
    onBackClick: () -> Unit,
    onSaveClick: (isSaved: Boolean, selectedUserId: Int) -> Unit
) {
    // TODO: move 'Деталі користувача' to string resources
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                title = {
                    Text("Деталі користувача", color = Color.White)
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            tint = Color.White,
                            contentDescription = null
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { onSaveClick(!userDetails.isSaved, userDetails.id) }) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            tint = if (userDetails.isSaved) Color.Yellow else Color.White,
                            modifier = Modifier.size(25.dp),
                            contentDescription = null
                        )
                    }
                },
            )
        },
    ) {
        it
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current).data(userDetails.avatarUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .clip(CircleShape)
                    .size(150.dp)
            )
            Text(
                text = userDetails.login,
                modifier = Modifier.padding(top = 10.dp),
                fontWeight = FontWeight.Bold
            )
            Text(text = userDetails.name, modifier = Modifier.padding(top = 10.dp))
            Text(text = userDetails.location, modifier = Modifier.padding(top = 10.dp))
        }
    }
}