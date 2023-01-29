package com.composemvimonolithtemplate.presentation.screens.info

import com.composemvimonolithtemplate.domain.model.InfoData

data class InfoScreenState(
    val infoData: InfoData?
) {
    companion object {
        fun getInitial(): InfoScreenState {
            return InfoScreenState(infoData = null)
        }
    }
}

sealed interface InfoScreenEvent {
    object FetchInfoData : InfoScreenEvent
}