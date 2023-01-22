package com.composemvimonolithtemplate.domain.use_case.get_user_info

import com.composemvimonolithtemplate.domain.model.UserInfo

interface GetUserInfoUseCase {

    suspend operator fun invoke(): UserInfo
}