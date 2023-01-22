package com.composemvimonolithtemplate.presentation.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.composemvimonolithtemplate.domain.model.UserInfo
import com.composemvimonolithtemplate.presentation.navigation.Screen
import com.composemvimonolithtemplate.presentation.theme.Loading
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(navController: NavController) {
    val viewModel = koinViewModel<HomeViewModel>()
    val context = LocalContext.current

    when (val screenState = viewModel.screenState.collectAsState().value) {
        is HomeScreenState.Loading -> Loading()
        is HomeScreenState.ShowUsers -> ShowUsers(
            users = screenState.users,
            onUserClick = { navController.navigate(Screen.Info.route) }
        )
    }
}

@Composable
fun ShowUsers(users: List<UserInfo>, onUserClick: (UserInfo) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = users, key = { it.email }) { userInfo ->
            UserItem(userInfo = userInfo, onUserClick = onUserClick)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun UserItem(userInfo: UserInfo, onUserClick: (UserInfo) -> Unit) {
    val backgroundShape = RoundedCornerShape(16.dp)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Color.Gray, shape = backgroundShape)
            .clip(shape = backgroundShape)
            .clickable { onUserClick(userInfo) }
            .padding(15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        GlideImage(
            modifier = Modifier.size(60.dp),
            model = userInfo.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier.padding(start = 10.dp)) {
            Text(
                text = "Name: ${userInfo.name}",
                fontSize = 18.sp
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "Email: ${userInfo.email}",
                fontSize = 18.sp
            )
        }
    }
}