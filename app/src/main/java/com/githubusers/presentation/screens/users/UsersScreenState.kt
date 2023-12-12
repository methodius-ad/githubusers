package com.githubusers.presentation.screens.users

import com.githubusers.domain.model.User

data class UsersScreenState(
    val usersData: List<User>?,
) {
    companion object {
        fun getInitial(): UsersScreenState {
            return UsersScreenState(usersData = null)
        }
    }
}

sealed interface UsersScreenEvent {
    object FetchUsersData : UsersScreenEvent
    data class ChangeUserStarStatus(val isSaved: Boolean, val selectedUserId: Int): UsersScreenEvent
}