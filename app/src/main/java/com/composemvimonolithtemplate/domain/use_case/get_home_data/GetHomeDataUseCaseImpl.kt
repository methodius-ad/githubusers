package com.composemvimonolithtemplate.domain.use_case.get_home_data

import com.composemvimonolithtemplate.domain.model.HomeData
import com.composemvimonolithtemplate.domain.repository.MockRepository

class GetHomeDataUseCaseImpl(
    private val mockRepository: MockRepository
) : GetHomeDataUseCase {

    override suspend fun invoke(): HomeData {
        return mockRepository.getHomeData()
    }
}