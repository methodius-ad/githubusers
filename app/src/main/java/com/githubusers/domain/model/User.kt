package com.githubusers.domain.model

data class User(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val isSaved: Boolean = false
)
