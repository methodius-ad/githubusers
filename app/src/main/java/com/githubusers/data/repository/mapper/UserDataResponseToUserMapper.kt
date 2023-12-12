package com.githubusers.data.repository.mapper

import com.githubusers.data.model.response.UserResponse
import com.githubusers.domain.model.User

fun UserResponse.toUser(): User {
    return User(id, login, avatarUrl)
}