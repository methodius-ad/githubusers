package com.composemvimonolithtemplate.presentation.screens.info

import androidx.lifecycle.viewModelScope
import com.composemvimonolithtemplate.domain.use_case.get_info_data.GetInfoDataUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class InfoScreenViewModelImpl(
    private val getInfoDataUseCase: GetInfoDataUseCase
) : InfoScreenViewModel() {

    override val screenState = MutableStateFlow(InfoScreenState.getInitial())

    init {
        handleEvent(InfoScreenEvent.FetchInfoData)
    }

    override fun handleEvent(event: InfoScreenEvent) {
        when (event) {
            is InfoScreenEvent.FetchInfoData -> onFetchInfoData()
        }
    }

    private fun onFetchInfoData() {
        viewModelScope.launch(Dispatchers.IO) {
            screenState.emit(screenState.value.copy(infoData = getInfoDataUseCase()))
        }
    }
}