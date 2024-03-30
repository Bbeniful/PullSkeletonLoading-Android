package com.bbeniful.pullskeletonloading.pullToRefresh.presentation

import androidx.compose.runtime.Immutable

class PullToRefreshUIState {

    @Immutable
    data class UIState(
        var isLoading: Boolean = false,
        var data: List<String> = listOf()
    )
}