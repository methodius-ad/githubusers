package com.composemvimonolithtemplate.domain.use_case.get_profile_data

import com.composemvimonolithtemplate.domain.model.ProfileData
import com.composemvimonolithtemplate.domain.repository.MockRepository

class GetProfileDataUseCaseImpl(
    private val mockRepository: MockRepository
) : GetProfileDataUseCase {

    override suspend fun invoke(): ProfileData {
        return mockRepository.getProfileData()
    }
}