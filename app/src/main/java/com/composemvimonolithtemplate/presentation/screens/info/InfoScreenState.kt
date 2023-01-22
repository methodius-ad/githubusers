package com.composemvimonolithtemplate.presentation.screens.info

import com.composemvimonolithtemplate.domain.model.InfoData

sealed interface InfoScreenState {
    object Loading : InfoScreenState
    data class ShowInfoData(val infoData: InfoData) : InfoScreenState
}

sealed interface InfoScreenEvent {
    object FetchInfoData : InfoScreenEvent
}