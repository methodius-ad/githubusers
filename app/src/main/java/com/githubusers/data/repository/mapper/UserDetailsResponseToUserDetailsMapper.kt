package com.githubusers.data.repository.mapper

import com.githubusers.data.model.response.UserDetailsResponse
import com.githubusers.domain.model.UserDetails

fun UserDetailsResponse.toUserDetails(isSaved: Boolean): UserDetails {
    return UserDetails(
        id,
        login,
        avatarUrl,
        name,
        location,
        isSaved
    )
}