package com.bbeniful.pullskeletonloading.pullToRefresh.PullToRefreshTwo

import androidx.lifecycle.ViewModel
import com.bbeniful.pullskeletonloading.pullToRefresh.presentation.PullToRefreshUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class PullToRefreshOtherViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(PullToRefreshUIState.UIState())
    val uiState = _uiState.asStateFlow()

    fun loadData(){

    }
}