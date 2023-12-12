package com.githubusers.domain.use_case.fetch_user_details

import com.githubusers.data.DataResult
import com.githubusers.domain.model.UserDetails
import com.githubusers.domain.repository.UsersRepository

class FetchUserDetailsUseCaseImpl(
    private val repository: UsersRepository
) : FetchUserDetailsUseCase {

    override suspend fun invoke(userLogin: String): DataResult<UserDetails> {
        return repository.fetchUserDetails(userLogin)
    }
}