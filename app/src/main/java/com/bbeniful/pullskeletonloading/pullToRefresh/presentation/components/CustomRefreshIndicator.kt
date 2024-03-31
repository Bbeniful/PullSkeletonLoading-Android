package com.bbeniful.pullskeletonloading.pullToRefresh.presentation.components

import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput

@Composable
fun CustomRefreshIndicator(modifier: Modifier = Modifier, text: String, icon: ImageVector, onPull: () -> Unit) {
    Box(modifier = modifier.pullDown { onPull() }) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Icon(imageVector = icon, contentDescription = null)
            Text(text = text)
        }
    }
}


@Composable
fun Modifier.pullDown(block: () -> Unit):Modifier{
    return composed {
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        this.pointerInput(Unit) {
            detectDragGestures { change, dragAmount ->
                change.consume()

                val (x,y) = dragAmount
                when {
                    x > 0 ->{ /* right */ }
                    x < 0 ->{ /* left */ }
                }
                when {
                    y > 0 -> { block() }
                    y < 0 -> { /* up */ }
                }

                offsetX += dragAmount.x
                offsetY += dragAmount.y
            }
        }
    }

}