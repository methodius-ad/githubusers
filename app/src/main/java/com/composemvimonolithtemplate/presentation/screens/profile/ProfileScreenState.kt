package com.composemvimonolithtemplate.presentation.screens.profile

import com.composemvimonolithtemplate.domain.model.UserInfo

sealed class ProfileScreenState {
    object Loading : ProfileScreenState()
    data class ShowUserInfo(val userInfo: UserInfo) : ProfileScreenState()
}

sealed class ProfileScreenEvent {
    object FetchUserInfo : ProfileScreenEvent()
    object UpdateUserInfo : ProfileScreenEvent()
}