package com.composemvimonolithtemplate.domain.use_case.get_info_data

import com.composemvimonolithtemplate.domain.model.InfoData
import com.composemvimonolithtemplate.domain.repository.MockRepository

class GetInfoDataUseCaseImpl(
    private val mockRepository: MockRepository
) : GetInfoDataUseCase {

    override suspend fun invoke(): InfoData {
        return mockRepository.getInfoData()
    }
}