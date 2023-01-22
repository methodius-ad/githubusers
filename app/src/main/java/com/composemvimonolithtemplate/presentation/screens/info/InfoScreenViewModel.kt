package com.composemvimonolithtemplate.presentation.screens.info

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class InfoScreenViewModel : ViewModel() {

    abstract val screenState: StateFlow<InfoScreenState>

    abstract fun handleEvent(event: InfoScreenEvent)
}