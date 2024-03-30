package com.bbeniful.pullskeletonloading.pullToRefresh.PullToRefreshTwo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshOther() {
    val viewModel = viewModel<PullToRefreshOtherViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    val pullToRefreshState = rememberPullToRefreshState()

    Box(
        modifier = Modifier
            .nestedScroll(pullToRefreshState.nestedScrollConnection)
            .fillMaxSize()
    ) {
        LazyColumn {
            items(uiState.data) {

            }
        }

        if (pullToRefreshState.isRefreshing) {
            LaunchedEffect(true) {
                viewModel.loadData()
            }
        }

        LaunchedEffect(uiState.isLoading) {
            if (uiState.isLoading) {
                pullToRefreshState.startRefresh()
            } else {
                pullToRefreshState.endRefresh()
            }
        }

        PullToRefreshContainer(
            state = pullToRefreshState,
            modifier = Modifier.align(Alignment.TopCenter)
        )

    }
}