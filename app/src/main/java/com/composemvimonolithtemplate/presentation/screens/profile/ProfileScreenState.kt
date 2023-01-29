package com.composemvimonolithtemplate.presentation.screens.profile

import com.composemvimonolithtemplate.domain.model.ProfileData

data class ProfileScreenState(
    val profileData: ProfileData?
) {
    companion object {
        fun getInitial(): ProfileScreenState {
            return ProfileScreenState(profileData = null)
        }
    }
}

sealed interface ProfileScreenEvent {
    object FetchProfileData : ProfileScreenEvent
}