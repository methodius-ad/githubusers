package com.composemvimonolithtemplate.presentation.screens.home

import com.composemvimonolithtemplate.domain.model.HomeData

sealed interface HomeScreenState {
    object Loading : HomeScreenState
    data class ShowHomeData(val homeData: HomeData) : HomeScreenState
}

sealed interface HomeScreenEvent {
    object FetchHomeData : HomeScreenEvent
}