package com.githubusers.presentation.screens.users

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class UsersViewModel : ViewModel() {

    abstract val screenState: StateFlow<UsersScreenState>

    abstract fun handleEvent(event: UsersScreenEvent)
}