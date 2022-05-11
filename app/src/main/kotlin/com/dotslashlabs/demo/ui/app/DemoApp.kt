package com.dotslashlabs.demo.ui.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.dotslashlabs.demo.ui.screen.home.HomeScreen

val screenList = listOf(
    HomeScreen,
)

@Composable
fun DemoApp(
    appState: DemoAppState = rememberDemoAppState(),
) {
    NavHost(
        navController = appState.navController,
        startDestination = Screen.Home.route,
    ) {
        screenList.map { demoScreen ->
            composable(
                route = demoScreen.screen.route,
                arguments = demoScreen.arguments(),
            ) { backStackEntry ->
                demoScreen.Screen(appState, backStackEntry)
            }
        }
    }
}
