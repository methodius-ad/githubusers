package com.composemvimonolithtemplate.presentation.screens.profile

import androidx.lifecycle.viewModelScope
import com.composemvimonolithtemplate.domain.use_case.get_profile_data.GetProfileDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProfileViewModelImpl(
    private val getProfileDataUseCase: GetProfileDataUseCase
) : ProfileViewModel() {

    override val screenState = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Loading)

    init {
        handleEvent(ProfileScreenEvent.FetchProfileData)
    }

    override fun handleEvent(event: ProfileScreenEvent) {
        when (event) {
            is ProfileScreenEvent.FetchProfileData -> onFetchProfileData()
        }
    }

    private fun onFetchProfileData() {
        viewModelScope.launch(Dispatchers.IO) {
            screenState.emit(ProfileScreenState.Loading)
            screenState.emit(ProfileScreenState.ShowProfileData(profileData = getProfileDataUseCase()))
        }
    }
}