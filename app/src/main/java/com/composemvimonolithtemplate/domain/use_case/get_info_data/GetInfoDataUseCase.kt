package com.composemvimonolithtemplate.domain.use_case.get_info_data

import com.composemvimonolithtemplate.domain.model.InfoData

interface GetInfoDataUseCase {

    suspend operator fun invoke(): InfoData
}