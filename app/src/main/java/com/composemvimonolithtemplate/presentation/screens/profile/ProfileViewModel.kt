package com.composemvimonolithtemplate.presentation.screens.profile

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class ProfileViewModel : ViewModel() {

    abstract val screenState: StateFlow<ProfileScreenState>

    abstract fun handleEvent(event: ProfileScreenEvent)
}