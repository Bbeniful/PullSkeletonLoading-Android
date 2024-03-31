package com.bbeniful.pullskeletonloading.pullToRefresh.presentation.PullToRefresh

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bbeniful.pullskeletonloading.pullToRefresh.presentation.components.CustomRefreshIndicator
import com.bbeniful.pullskeletonloading.skeleton.presentation.SkeletonLoading
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PullToRefreshOther() {
    val viewModel = viewModel<PullToRefreshViewModel>()
    val uiState by viewModel.uiState.collectAsState()

    val pullToRefreshState = rememberPullToRefreshState(
        positionalThreshold = 120.dp
    )

    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .nestedScroll(pullToRefreshState.nestedScrollConnection)
    ) {
        // val test = listOf("1", "2", "3", "4")
        var test = emptyList<String>()

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            val heightOfPoBox =
                if (test.isEmpty()) 120.dp else (pullToRefreshState.progress * 100).roundToInt().dp

            val infiniteTransition = rememberInfiniteTransition(label = "")

            val offset by infiniteTransition.animateFloat(
                initialValue = 0f,
                targetValue = 25f,
                animationSpec = infiniteRepeatable(
                    animation = tween(1000),
                    repeatMode = RepeatMode.Reverse
                ), label = ""
            )

            if (!pullToRefreshState.isRefreshing && uiState.data.isEmpty()) {
                CustomRefreshIndicator(
                    modifier = Modifier
                        .offset(y = offset.dp)
                        .fillMaxWidth()
                        .height(heightOfPoBox),
                    text = "Pull to refresh",
                    icon = Icons.Default.KeyboardArrowDown
                ) {
                    pullToRefreshState.startRefresh()
                }
            }

            AnimatedVisibility(
                pullToRefreshState.isRefreshing,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                SkeletonLoading(RoundedCornerShape(12.dp))
            }

            AnimatedVisibility(
                !pullToRefreshState.isRefreshing,
                enter = fadeIn(),
                exit = fadeOut()
            ) {
                LazyColumn(Modifier.padding(12.dp)) {
                    items(uiState.data) {
                        TestItem(text = it)
                    }
                }
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

        if (!pullToRefreshState.isRefreshing) {
            PullToRefreshContainer(
                state = pullToRefreshState,
                modifier = Modifier.align(Alignment.TopCenter)
            )
        }
    }
}


@Composable
fun TestItem(text: String) {
    Column {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column() {
                Text(
                    text = "Long text hello $text",
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    text = "Simple one ", color = Color.Black,
                    fontSize = 16.sp
                )
                Text(
                    text = "Simple one ", color = Color.Black,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Simple one ", color = Color.Black,
                    fontSize = 16.sp
                )
            }
            Button(onClick = { Log.e("I'm", " has been clicked $text") }) {
                Text(text = "Click to me")
            }
        }
    }
}
