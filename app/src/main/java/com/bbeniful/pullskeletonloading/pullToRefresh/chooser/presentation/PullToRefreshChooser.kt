package com.bbeniful.pullskeletonloading.pullToRefresh.chooser.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun PullToRefreshChooser(
    onPullToRefreshOne: () -> Unit,
    onPullToRefreshOther: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = onPullToRefreshOne) {
            Text(text = "One")
        }

        Button(onClick = onPullToRefreshOther) {
            Text(text = "Other")
        }
    }
}