package com.githubusers.presentation.screens.info

import androidx.lifecycle.viewModelScope
import com.githubusers.data.getDataResult
import com.githubusers.domain.use_case.change_saved_status.ChangeSavedStatusUseCase
import com.githubusers.domain.use_case.fetch_user_details.FetchUserDetailsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UserDetailsScreenViewModelImpl(
    private val fetchUserDetailsUseCase: FetchUserDetailsUseCase, private val userLogin: String,
    private val changeSavedStatusUseCase: ChangeSavedStatusUseCase
) : UserDetailsScreenViewModel() {

    override val screenState = MutableStateFlow(UserDetailsScreenState.getInitial())

    init {
        handleEvent(UserDetailsScreenEvent.FetchUserDetailsData)
    }

    override fun handleEvent(event: UserDetailsScreenEvent) {
        when (event) {
            is UserDetailsScreenEvent.FetchUserDetailsData -> onFetchInfoData()
            is UserDetailsScreenEvent.ChangeUserStarStatus -> onChangeUserStarStatus(
                event.isSaved,
                event.selectedUserId
            )
        }
    }

    private fun onFetchInfoData() {
        viewModelScope.launch {
            processInfoFetching()
        }
    }

    private fun onChangeUserStarStatus(isSaved: Boolean, selectedUserId: Int) {
        viewModelScope.launch {
            changeSavedStatusUseCase(isSaved, selectedUserId)
            processInfoFetching()
        }
    }

    private suspend fun processInfoFetching() {
        screenState.value =
            screenState.value.copy(infoData = fetchUserDetailsUseCase(userLogin).getDataResult())
    }
}