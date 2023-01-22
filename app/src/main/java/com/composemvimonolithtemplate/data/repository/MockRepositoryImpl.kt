package com.composemvimonolithtemplate.data.repository

import com.composemvimonolithtemplate.data.model.response.HomeDataResponse
import com.composemvimonolithtemplate.data.model.response.InfoDataResponse
import com.composemvimonolithtemplate.data.model.response.ProfileDataResponse
import com.composemvimonolithtemplate.data.repository.mapper.mapToHomeData
import com.composemvimonolithtemplate.data.repository.mapper.mapToInfoData
import com.composemvimonolithtemplate.data.repository.mapper.mapToProfileData
import com.composemvimonolithtemplate.domain.model.HomeData
import com.composemvimonolithtemplate.domain.model.InfoData
import com.composemvimonolithtemplate.domain.model.ProfileData
import com.composemvimonolithtemplate.domain.repository.MockRepository
import kotlinx.coroutines.delay

class MockRepositoryImpl : MockRepository {

    override suspend fun getHomeData(): HomeData {
        delay(1500L)
        return HomeDataResponse(title = "Home Screen").mapToHomeData()
    }

    override suspend fun getProfileData(): ProfileData {
        delay(1500L)
        return ProfileDataResponse(title = "Profile Screen").mapToProfileData()
    }

    override suspend fun getInfoData(): InfoData {
        delay(1500L)
        return InfoDataResponse(title = "Info Screen").mapToInfoData()
    }
}