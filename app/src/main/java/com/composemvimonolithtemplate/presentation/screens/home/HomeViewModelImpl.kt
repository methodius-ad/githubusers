package com.composemvimonolithtemplate.presentation.screens.home

import androidx.lifecycle.viewModelScope
import com.composemvimonolithtemplate.domain.use_case.get_users.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val getUsersUseCase: GetUsersUseCase
) : HomeViewModel() {

    override val screenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)

    init {
        handleEvent(HomeScreenEvent.FetchUsers)
    }

    override fun handleEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.FetchUsers -> onFetchUsers()
        }
    }

    private fun onFetchUsers() {
        viewModelScope.launch(Dispatchers.IO) {
            screenState.emit(HomeScreenState.Loading)
            screenState.emit(HomeScreenState.ShowUsers(users = getUsersUseCase()))
        }
    }
}