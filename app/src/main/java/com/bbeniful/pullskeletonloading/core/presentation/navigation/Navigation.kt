package com.bbeniful.pullskeletonloading.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bbeniful.pullskeletonloading.core.presentation.ChooserView
import com.bbeniful.pullskeletonloading.pullToRefresh.presentation.PullToRefresh.PullToRefreshOther
import com.bbeniful.pullskeletonloading.skeleton.presentation.SkeletonLoadingPreview

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Chooser.path) {
        composable(Routes.Chooser.path) {
            ChooserView(onSkeletonClick = {
                navController.navigate(Routes.SkeletonLoading.path)
            }, onPullToRefreshChooserClick = {
                navController.navigate(Routes.PullToRefres.path)
            })
        }

        composable(Routes.SkeletonLoading.path) {
            SkeletonLoadingPreview()
        }

        composable(Routes.PullToRefres.path) {
            PullToRefreshOther()
        }

    }
}

sealed class Routes(val path: String) {
    data object Chooser : Routes(path = "chooser")

    data object SkeletonLoading : Routes(path = "skeleton")

    data object PullToRefres : Routes(path = "pull_to_refresh")
}