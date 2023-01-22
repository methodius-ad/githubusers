package com.composemvimonolithtemplate.domain.use_case.get_profile_data

import com.composemvimonolithtemplate.domain.model.ProfileData

interface GetProfileDataUseCase {

    suspend operator fun invoke(): ProfileData
}