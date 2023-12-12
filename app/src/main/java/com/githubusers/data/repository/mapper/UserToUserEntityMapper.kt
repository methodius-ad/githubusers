package com.githubusers.data.repository.mapper

import com.githubusers.data.model.local.UserEntity
import com.githubusers.domain.model.User

fun User.toUserEntity(): UserEntity {
    return UserEntity(
        id = id,
        login = login,
        avatarUrl = avatarUrl,
        isSaved = false
    )
}