package com.composemvimonolithtemplate.presentation.screens.profile

import androidx.lifecycle.viewModelScope
import com.composemvimonolithtemplate.domain.use_case.get_user_info.GetUserInfoUseCase
import com.composemvimonolithtemplate.domain.use_case.update_user_info.UpdateUserInfoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ProfileViewModelImpl(
    private val getUserInfoUseCase: GetUserInfoUseCase,
    private val updateUserInfoUseCase: UpdateUserInfoUseCase
) : ProfileViewModel() {

    override val screenState = MutableStateFlow<ProfileScreenState>(ProfileScreenState.Loading)

    init {
        handleEvent(ProfileScreenEvent.FetchUserInfo)
    }

    override fun handleEvent(event: ProfileScreenEvent) {
        when (event) {
            is ProfileScreenEvent.FetchUserInfo -> onFetchUserInfo()
            is ProfileScreenEvent.UpdateUserInfo -> onUpdateUserInfo()
        }
    }

    private fun onFetchUserInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            screenState.emit(ProfileScreenState.Loading)
            screenState.emit(ProfileScreenState.ShowUserInfo(userInfo = getUserInfoUseCase()))
        }
    }

    private fun onUpdateUserInfo() {
        viewModelScope.launch(Dispatchers.IO) {
            screenState.emit(ProfileScreenState.Loading)
            screenState.emit(ProfileScreenState.ShowUserInfo(userInfo = updateUserInfoUseCase()))
        }
    }
}