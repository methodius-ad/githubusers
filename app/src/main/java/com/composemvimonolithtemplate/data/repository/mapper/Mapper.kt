package com.composemvimonolithtemplate.data.repository.mapper

import com.composemvimonolithtemplate.data.model.response.HomeDataResponse
import com.composemvimonolithtemplate.data.model.response.InfoDataResponse
import com.composemvimonolithtemplate.data.model.response.ProfileDataResponse
import com.composemvimonolithtemplate.domain.model.HomeData
import com.composemvimonolithtemplate.domain.model.InfoData
import com.composemvimonolithtemplate.domain.model.ProfileData

fun HomeDataResponse.mapToHomeData(): HomeData {
    return HomeData(title = title)
}

fun ProfileDataResponse.mapToProfileData(): ProfileData {
    return ProfileData(title = title)
}

fun InfoDataResponse.mapToInfoData(): InfoData {
    return InfoData(title = title)
}