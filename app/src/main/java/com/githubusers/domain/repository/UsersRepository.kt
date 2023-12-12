package com.githubusers.domain.repository

import com.githubusers.data.DataResult
import com.githubusers.domain.model.User
import com.githubusers.domain.model.UserDetails

interface UsersRepository {

    suspend fun fetchUsers(): DataResult<List<User>>

    suspend fun fetchUserDetails(userLogin: String): DataResult<UserDetails>

    suspend fun changeSavedStatus(isSaved: Boolean, userId: Int)
}