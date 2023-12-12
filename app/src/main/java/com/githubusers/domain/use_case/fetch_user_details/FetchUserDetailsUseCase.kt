package com.githubusers.domain.use_case.fetch_user_details

import com.githubusers.data.DataResult
import com.githubusers.domain.model.UserDetails

interface FetchUserDetailsUseCase {

    suspend operator fun invoke(userLogin: String): DataResult<UserDetails>
}