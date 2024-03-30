package com.bbeniful.pullskeletonloading.pullToRefresh.presentation.pullToRefreshOne

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bbeniful.pullskeletonloading.pullToRefresh.presentation.PullToRefreshUIState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PullToRefreshViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PullToRefreshUIState.UIState())
    val uiState = _uiState.asStateFlow()


    fun refreshState() {
        viewModelScope.launch {
            setLoading(true)
            delay(5_000)
            setLoading(false)
        }
    }

    private fun setLoading(value: Boolean){
        _uiState.update {
            it.copy(
                isLoading = value
            )
        }
    }
}