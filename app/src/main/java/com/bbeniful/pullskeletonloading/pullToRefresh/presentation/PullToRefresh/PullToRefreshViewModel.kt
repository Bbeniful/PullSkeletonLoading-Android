package com.bbeniful.pullskeletonloading.pullToRefresh.presentation.PullToRefresh

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bbeniful.pullskeletonloading.pullToRefresh.presentation.PullToRefreshUIState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PullToRefreshViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(PullToRefreshUIState.UIState())
    val uiState = _uiState.asStateFlow()

    init {
        loadData()
    }

    fun loadData(){
        viewModelScope.launch {
            setLoading(true)
            delay(3_000)
            setLoading(false)
            setData()
        }

    }

    private fun setData() {
        _uiState.update {
            it.copy(
                data = listOf("1","2","3","4")
            )
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