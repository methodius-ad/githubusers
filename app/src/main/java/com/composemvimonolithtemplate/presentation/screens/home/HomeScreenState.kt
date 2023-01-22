package com.composemvimonolithtemplate.presentation.screens.home

import com.composemvimonolithtemplate.domain.model.UserInfo

sealed class HomeScreenState {
    object Loading : HomeScreenState()
    data class ShowUsers(val users: List<UserInfo>) : HomeScreenState()
}

sealed class HomeScreenEvent {
    object FetchUsers : HomeScreenEvent()
}