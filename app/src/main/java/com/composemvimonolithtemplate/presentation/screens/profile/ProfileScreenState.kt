package com.composemvimonolithtemplate.presentation.screens.profile

import com.composemvimonolithtemplate.domain.model.ProfileData

sealed interface ProfileScreenState {
    object Loading : ProfileScreenState
    data class ShowProfileData(val profileData: ProfileData) : ProfileScreenState
}

sealed interface ProfileScreenEvent {
    object FetchProfileData : ProfileScreenEvent
}