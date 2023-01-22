package com.composemvimonolithtemplate.data.repository.mapper

import com.composemvimonolithtemplate.data.model.response.UserInfoResponse
import com.composemvimonolithtemplate.domain.model.UserInfo

fun UserInfoResponse.mapToUserInfo(): UserInfo {
    return UserInfo(
        name = name,
        email = email,
        imageUrl = imageUrl
    )
}