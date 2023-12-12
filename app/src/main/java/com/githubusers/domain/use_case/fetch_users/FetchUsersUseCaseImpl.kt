package com.githubusers.domain.use_case.fetch_users

import com.githubusers.data.DataResult
import com.githubusers.domain.model.User
import com.githubusers.domain.repository.UsersRepository

class FetchUsersUseCaseImpl(
    private val repository: UsersRepository
) : FetchUsersUseCase {

    override suspend fun invoke(): DataResult<List<User>> {
        return repository.fetchUsers()
    }
}