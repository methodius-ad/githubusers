package com.composemvimonolithtemplate.domain.repository

import com.composemvimonolithtemplate.domain.model.UserInfo

interface MockRepository {

    suspend fun getUserInfo(): UserInfo

    suspend fun updateUserInfo(): UserInfo
}