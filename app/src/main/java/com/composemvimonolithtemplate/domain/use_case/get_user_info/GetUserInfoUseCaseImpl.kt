package com.composemvimonolithtemplate.domain.use_case.get_user_info

import com.composemvimonolithtemplate.domain.model.UserInfo
import com.composemvimonolithtemplate.domain.repository.MockRepository

class GetUserInfoUseCaseImpl(
    private val mockRepository: MockRepository
) : GetUserInfoUseCase {

    override suspend fun invoke(): UserInfo {
        return mockRepository.getUserInfo()
    }
}