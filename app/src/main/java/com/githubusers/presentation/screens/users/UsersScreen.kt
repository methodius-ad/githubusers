package com.githubusers.presentation.screens.users

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.githubusers.R
import com.githubusers.domain.model.User
import com.githubusers.presentation.navigation.Screen
import com.githubusers.presentation.theme.Loading
import org.koin.androidx.compose.koinViewModel

@Composable
fun UsersScreen(navController: NavController) {
    val viewModel = koinViewModel<UsersViewModel>()
    val screenState = viewModel.screenState.collectAsState()
    var isFilterSelected by remember {
        mutableStateOf(false)
    }

    viewModel.handleEvent(UsersScreenEvent.FetchUsersData)

    screenState.value.usersData?.let { users ->
        ShowUsersData(users, isFilterSelected, onShowInfoScreenClick = { userLogin ->
            navController.navigate("${Screen.UserDetails.route}/$userLogin")
        }, onFilterClick = {
            isFilterSelected = !isFilterSelected;
        }, onSaveClick = { isSaved, selectedUserId ->
            viewModel.handleEvent(UsersScreenEvent.ChangeUserStarStatus(isSaved, selectedUserId))
        })
    } ?: Loading()
}

@Composable
private fun ShowUsersData(
    users: List<User>,
    isFilterSelected: Boolean,
    onShowInfoScreenClick: (login: String) -> Unit,
    onFilterClick: () -> Unit,
    onSaveClick: (isSaved: Boolean, userId: Int) -> Unit
) {
    val sortedUsers: List<User> = if (isFilterSelected) {
        users.sortedBy { it.login.lowercase() }
    } else {
        users
    }

    // TODO: move 'Користувачі GitHub' to string resources
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.LightGray,
                title = {
                    Text("Користувачі GitHub", color = Color.White)
                },
                actions = {
                    IconButton(onClick = onFilterClick) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter_icon),
                            modifier = Modifier.size(25.dp),
                            tint = if (isFilterSelected) Color.Yellow else Color.White,
                            contentDescription = null
                        )
                    }
                },
            )
        },
    ) {
        it
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            var currentFirstChar: Char? = null
            items(sortedUsers.size) { itemIndex ->
                val firstChar = sortedUsers[itemIndex].login.firstOrNull()?.uppercaseChar()

                if (isFilterSelected && firstChar != currentFirstChar) {
                    currentFirstChar = firstChar
                    Text(
                        text = firstChar.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        color = Color.Gray
                    )
                }
                ShowUserItem(sortedUsers[itemIndex], onShowInfoScreenClick, onSaveClick)
            }
        }
    }
}

@Composable
private fun ShowUserItem(
    user: User,
    onShowInfoScreenClick: (login: String) -> Unit,
    onSaveClick: (isSaved: Boolean, userId: Int) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(top = 10.dp)
            .fillMaxWidth()
            .clickable {
                onShowInfoScreenClick(user.login)
            }) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(user.avatarUrl).crossfade(true)
                .build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(CircleShape)
                .size(50.dp)
        )
        Text(text = user.login)
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = { onSaveClick(!user.isSaved, user.id) }) {
            Icon(
                imageVector = Icons.Default.Star,
                tint = if (user.isSaved) Color.Yellow else Color.Gray,
                modifier = Modifier.padding(16.dp),
                contentDescription = null
            )
        }
    }
}