package com.bbeniful.pullskeletonloading.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.bbeniful.pullskeletonloading.core.presentation.ChooserView
import com.bbeniful.pullskeletonloading.pullToRefresh.PullToRefreshTwo.PullToRefreshOther
import com.bbeniful.pullskeletonloading.pullToRefresh.chooser.presentation.PullToRefreshChooser
import com.bbeniful.pullskeletonloading.pullToRefresh.presentation.pullToRefreshOne.PullToRefreshView
import com.bbeniful.pullskeletonloading.skeleton.presentation.SkeletonLoadingPreview

@Composable
fun Navigations() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.Chooser.path) {
        composable(Routes.Chooser.path) {
            ChooserView(onSkeletonClick = {
                navController.navigate(Routes.SkeletonLoading.path)
            }, onPullToRefreshChooserClick = {
                navController.navigate(Routes.PullToRefreshChooser.path)
            })
        }

        composable(Routes.SkeletonLoading.path) {
            SkeletonLoadingPreview()
        }

        navigation(
            route = Routes.PullToRefreshChooser.path,
            startDestination = Routes.PullToRefreshChooserScreen.path
        ) {

            composable(Routes.PullToRefreshChooserScreen.path) {
                PullToRefreshChooser(onPullToRefreshOne = {
                    navController.navigate(Routes.PullToRefreshOne.path)
                }, onPullToRefreshOther = {
                    navController.navigate(Routes.PullToRefreshOther.path)
                })
            }
            composable(Routes.PullToRefreshOne.path) {
                PullToRefreshView()

            }
            composable(Routes.PullToRefreshOther.path) {
                PullToRefreshOther()
            }
        }
    }
}

sealed class Routes(val path: String) {
    data object Chooser : Routes(path = "chooser")

    data object SkeletonLoading : Routes(path = "skeleton")

    data object PullToRefreshChooser : Routes(path = "pull_to_refresh_chooser")
    data object PullToRefreshChooserScreen : Routes(path = "pull_to_refresh_chooser_screen")

    data object PullToRefreshOne : Routes(path = "pull_to_refresh_one")

    data object PullToRefreshOther : Routes(path = "pull_to_refresh_other")
}