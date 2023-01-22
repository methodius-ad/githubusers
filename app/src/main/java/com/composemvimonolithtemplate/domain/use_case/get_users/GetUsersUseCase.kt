package com.composemvimonolithtemplate.domain.use_case.get_users

import com.composemvimonolithtemplate.domain.model.UserInfo

interface GetUsersUseCase {

    suspend operator fun invoke(): List<UserInfo>
}