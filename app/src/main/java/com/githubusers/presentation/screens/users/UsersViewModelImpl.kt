package com.githubusers.presentation.screens.users

import androidx.lifecycle.viewModelScope
import com.githubusers.data.getDataResult
import com.githubusers.domain.use_case.change_saved_status.ChangeSavedStatusUseCase
import com.githubusers.domain.use_case.fetch_users.FetchUsersUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UsersViewModelImpl(
    private val fetchUsersUseCase: FetchUsersUseCase,
    private val changeSavedStatusUseCase: ChangeSavedStatusUseCase
) : UsersViewModel() {

    override val screenState = MutableStateFlow(UsersScreenState.getInitial())

    override fun handleEvent(event: UsersScreenEvent) {
        when (event) {
            is UsersScreenEvent.FetchUsersData -> onFetchUsersData()
            is UsersScreenEvent.ChangeUserStarStatus -> onChangeUserStarStatus(
                event.isSaved,
                event.selectedUserId
            )
        }
    }

    private fun onFetchUsersData() {
        viewModelScope.launch {
            processUsersFetching()
        }
    }

    private fun onChangeUserStarStatus(isSaved: Boolean, selectedUserId: Int) {
        viewModelScope.launch {
            changeSavedStatusUseCase(isSaved, selectedUserId)
            processUsersFetching()
        }
    }

    private suspend fun processUsersFetching() {
        screenState.value = screenState.value.copy(
            usersData = fetchUsersUseCase().getDataResult()
        )
    }
}