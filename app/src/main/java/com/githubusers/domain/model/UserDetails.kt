package com.githubusers.domain.model

data class UserDetails(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val name: String,
    val location: String,
    val isSaved: Boolean = false
)
