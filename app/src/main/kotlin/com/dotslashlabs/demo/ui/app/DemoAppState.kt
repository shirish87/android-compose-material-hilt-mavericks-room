package com.dotslashlabs.demo.ui.app

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

sealed class Screen(val route: String) {
    object Home : Screen("home")
}

@Composable
fun rememberDemoAppState(
    navController: NavHostController = rememberNavController(),
    context: Context = LocalContext.current,
) = remember(navController, context) {
    DemoAppState(navController, context)
}

class DemoAppState(
    val navController: NavHostController,
    private val context: Context,
) {
    fun navigateBack() {
        navController.popBackStack()
    }
}
