package com.composemvimonolithtemplate.domain.use_case.get_home_data

import com.composemvimonolithtemplate.domain.model.HomeData

interface GetHomeDataUseCase {

    suspend operator fun invoke(): HomeData
}