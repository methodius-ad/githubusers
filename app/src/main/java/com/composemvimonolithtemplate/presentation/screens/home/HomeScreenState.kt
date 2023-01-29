package com.composemvimonolithtemplate.presentation.screens.home

import com.composemvimonolithtemplate.domain.model.HomeData

data class HomeScreenState(
    val homeData: HomeData?
) {
    companion object {
        fun getInitial(): HomeScreenState {
            return HomeScreenState(homeData = null)
        }
    }
}

sealed interface HomeScreenEvent {
    object FetchHomeData : HomeScreenEvent
}