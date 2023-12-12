package com.githubusers.presentation.screens.info

import com.githubusers.domain.model.UserDetails

data class UserDetailsScreenState(
    val infoData: UserDetails?
) {
    companion object {
        fun getInitial(): UserDetailsScreenState {
            return UserDetailsScreenState(infoData = null)
        }
    }
}

sealed interface UserDetailsScreenEvent {
    object FetchUserDetailsData : UserDetailsScreenEvent
    data class ChangeUserStarStatus(val isSaved: Boolean, val selectedUserId: Int): UserDetailsScreenEvent
}