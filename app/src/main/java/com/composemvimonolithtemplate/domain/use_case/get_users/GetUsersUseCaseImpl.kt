package com.composemvimonolithtemplate.domain.use_case.get_users

import com.composemvimonolithtemplate.domain.model.UserInfo
import com.composemvimonolithtemplate.domain.repository.MockRepository

class GetUsersUseCaseImpl(
    private val mockRepository: MockRepository
) : GetUsersUseCase {

    override suspend fun invoke(): List<UserInfo> {
        return mockRepository.getUsers()
    }
}