package com.bbeniful.pullskeletonloading.pullToRefresh.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bbeniful.pullskeletonloading.pullToRefresh.presentation.components.CustomRefreshIndicator
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PullToRefreshView() {
    val viewModel = viewModel<PullToRefreshViewModel>()
    val uiState by viewModel.uiState.collectAsState()
    val pullToRefreshState =
        rememberPullRefreshState(
            refreshing = uiState.isLoading,
            onRefresh = { viewModel.refreshState() })

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pullRefresh(pullToRefreshState)
    ) {
        val test = listOf<String>()
        //val test = listOf("1", "2", "3", "4")

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            CustomRefreshIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height((pullToRefreshState.progress * 100).roundToInt().dp),
                text = "Pull to refresh",
                icon = Icons.Default.KeyboardArrowDown
            )
            LazyColumn(Modifier.fillMaxSize()) {
                items(test) {
                    Text(text = "hello $it", color = Color.White)
                }
            }
        }



        PullRefreshIndicator(refreshing = uiState.isLoading, state = pullToRefreshState)

    }
}