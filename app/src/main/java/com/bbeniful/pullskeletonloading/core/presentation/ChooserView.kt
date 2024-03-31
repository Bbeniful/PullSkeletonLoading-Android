package com.bbeniful.pullskeletonloading.core.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ChooserView(
    onSkeletonClick: () -> Unit,
    onPullToRefreshChooserClick: () -> Unit,
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = onSkeletonClick) {
                Text(text = "Skeleton loading")
            }

            Button(onClick = onPullToRefreshChooserClick) {
                Text(text = "Pull to refresh")
            }
        }
    }
}