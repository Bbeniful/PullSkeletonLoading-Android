package com.bbeniful.pullskeletonloading.skeleton.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bbeniful.pullskeletonloading.skeleton.presentation.components.SkeletonBox
import com.bbeniful.pullskeletonloading.skeleton.presentation.components.SkeletonText

@Composable
fun SkeletonLoadingPreview() {

    var isIosStyleSkeleton by remember {
        mutableStateOf(false)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = {
                isIosStyleSkeleton = !isIosStyleSkeleton
            }) {
                Text(text = if (isIosStyleSkeleton) "iOS" else "Android/Custom")
            }
        }
        SkeletonLoading(if (isIosStyleSkeleton) RectangleShape else RoundedCornerShape(25.dp))
    }
}

@Composable
fun SkeletonLoading(
    shape: Shape
) {
    Column {
        Row {
            Column {
                SkeletonText(
                    text = "Lorem ipsum",
                    fontSize = 18.sp,
                    color = Color.White,
                    shape = shape
                )
            }
            SkeletonBox(color = Color.LightGray, shape = shape)
        }
    }
}