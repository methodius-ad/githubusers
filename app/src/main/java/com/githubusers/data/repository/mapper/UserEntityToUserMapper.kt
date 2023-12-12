package com.githubusers.data.repository.mapper

import com.githubusers.data.model.local.UserEntity
import com.githubusers.domain.model.User

fun UserEntity.toUser(): User {
    return User(id, login, avatarUrl, isSaved)
}