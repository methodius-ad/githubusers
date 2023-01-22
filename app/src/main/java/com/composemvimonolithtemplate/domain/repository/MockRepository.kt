package com.composemvimonolithtemplate.domain.repository

import com.composemvimonolithtemplate.domain.model.HomeData
import com.composemvimonolithtemplate.domain.model.InfoData
import com.composemvimonolithtemplate.domain.model.ProfileData

interface MockRepository {

    suspend fun getHomeData(): HomeData

    suspend fun getProfileData(): ProfileData

    suspend fun getInfoData(): InfoData
}