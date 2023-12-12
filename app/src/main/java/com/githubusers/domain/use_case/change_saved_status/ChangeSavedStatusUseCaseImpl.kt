package com.githubusers.domain.use_case.change_saved_status

import com.githubusers.domain.repository.UsersRepository

class ChangeSavedStatusUseCaseImpl(
    private val repository: UsersRepository
) : ChangeSavedStatusUseCase {

    override suspend fun invoke(isSaved: Boolean, userId: Int) {
        repository.changeSavedStatus(isSaved, userId)
    }
}