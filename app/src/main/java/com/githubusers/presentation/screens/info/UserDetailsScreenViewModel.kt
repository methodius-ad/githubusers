package com.githubusers.presentation.screens.info

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class UserDetailsScreenViewModel : ViewModel() {

    abstract val screenState: StateFlow<UserDetailsScreenState>

    abstract fun handleEvent(event: UserDetailsScreenEvent)
}