package com.bbeniful.pullskeletonloading.skeleton.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.bbeniful.pullskeletonloading.skeleton.domain.extensions.shimmerLoadingAnimation

@Composable
fun SkeletonBox(
    modifier: Modifier = Modifier,
    color: Color,
    shape: Shape = RoundedCornerShape(5.dp)
) {
    Box(
        modifier = modifier
            .background(color = color, shape = shape)
            .shimmerLoadingAnimation(shape = shape)
    )
}