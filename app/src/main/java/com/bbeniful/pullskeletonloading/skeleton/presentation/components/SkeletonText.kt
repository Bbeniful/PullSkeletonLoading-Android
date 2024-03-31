package com.bbeniful.pullskeletonloading.skeleton.presentation.components

import android.text.TextUtils
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.bbeniful.pullskeletonloading.skeleton.domain.extensions.shimmerLoadingAnimation

@Composable
fun SkeletonText(modifier: Modifier = Modifier,text: String, fontSize: TextUnit, color: Color,
                 shape: Shape = RoundedCornerShape(5.dp)) {
    Box (modifier = Modifier.height(90.dp)
        .fillMaxWidth()
        .background(Color.LightGray, shape = shape)
        .blur(5.dp)
        .shimmerLoadingAnimation(shape = shape)){
        Text(
            text = text,
            modifier = modifier,
            color = color,
            fontSize = fontSize
        )
    }
}