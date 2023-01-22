package com.composemvimonolithtemplate.presentation.screens.home

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class HomeViewModel : ViewModel() {

    abstract val screenState: StateFlow<HomeScreenState>

    abstract fun handleEvent(event: HomeScreenEvent)
}