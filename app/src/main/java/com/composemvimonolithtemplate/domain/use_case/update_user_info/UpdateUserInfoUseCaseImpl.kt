package com.composemvimonolithtemplate.domain.use_case.update_user_info

import com.composemvimonolithtemplate.domain.model.UserInfo
import com.composemvimonolithtemplate.domain.repository.MockRepository

class UpdateUserInfoUseCaseImpl(
    private val mockRepository: MockRepository
) : UpdateUserInfoUseCase {

    override suspend fun invoke(): UserInfo {
        return mockRepository.updateUserInfo()
    }
}