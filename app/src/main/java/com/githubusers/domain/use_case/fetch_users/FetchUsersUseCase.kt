package com.githubusers.domain.use_case.fetch_users

import com.githubusers.data.DataResult
import com.githubusers.domain.model.User

interface FetchUsersUseCase {

    suspend operator fun invoke(): DataResult<List<User>>
}