package com.dotslashlabs.demo.ui.screen

import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.dotslashlabs.demo.ui.app.DemoAppState
import com.dotslashlabs.demo.ui.app.Screen

interface DemoScreen {
    val screen: Screen

    fun arguments(): List<NamedNavArgument>

    @Composable
    fun Screen(appState: DemoAppState, backStackEntry: NavBackStackEntry)
}
