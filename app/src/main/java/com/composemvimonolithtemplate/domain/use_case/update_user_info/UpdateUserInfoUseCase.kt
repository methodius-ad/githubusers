package com.composemvimonolithtemplate.domain.use_case.update_user_info

import com.composemvimonolithtemplate.domain.model.UserInfo

interface UpdateUserInfoUseCase {

    suspend operator fun invoke(): UserInfo
}