package com.composemvimonolithtemplate.presentation.screens.home

import androidx.lifecycle.viewModelScope
import com.composemvimonolithtemplate.domain.use_case.get_home_data.GetHomeDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class HomeViewModelImpl(
    private val getHomeDataUseCase: GetHomeDataUseCase
) : HomeViewModel() {

    override val screenState = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)

    init {
        handleEvent(HomeScreenEvent.FetchHomeData)
    }

    override fun handleEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.FetchHomeData -> onFetchHomeData()
        }
    }

    private fun onFetchHomeData() {
        viewModelScope.launch(Dispatchers.IO) {
            screenState.emit(HomeScreenState.Loading)
            screenState.emit(HomeScreenState.ShowHomeData(homeData = getHomeDataUseCase()))
        }
    }
}