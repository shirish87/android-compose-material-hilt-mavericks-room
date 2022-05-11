package com.dotslashlabs.demo.ui.screen.home

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.dotslashlabs.demo.R
import com.dotslashlabs.demo.ui.app.DemoAppState
import com.dotslashlabs.demo.ui.app.Screen
import com.dotslashlabs.demo.ui.screen.DemoScreen
import kotlinx.coroutines.launch

object HomeScreen : DemoScreen {
    override val screen: Screen
        get() = Screen.Home

    override fun arguments(): List<NamedNavArgument> = emptyList()

    @Composable
    override fun Screen(appState: DemoAppState, backStackEntry: NavBackStackEntry) {
        return Content(appState, backStackEntry)
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun Content(
    @Suppress("UNUSED_PARAMETER") appState: DemoAppState,
    @Suppress("UNUSED_PARAMETER") backStackEntry: NavBackStackEntry
) {
    val scope = rememberCoroutineScope()
    val viewModel: HomeViewModel = mavericksViewModel()

    val state by viewModel.collectAsState()
    val books = state.books() ?: emptyList()

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(stringResource(id = R.string.app_name)) },
                actions = {
                    IconButton(onClick = {
                        Toast.makeText(
                            appState.navController.context,
                            "Foo Bar",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }) {
                        Icon(
                            imageVector = Icons.Outlined.Settings,
                            contentDescription = "",
                        )
                    }
                }
            )
        },
        content = { contentPadding ->
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(contentPadding),
            ) {
                items(count = books.size) { index ->
                    Text(
                        text = books[index].title,
                        modifier = Modifier
                            .clickable(
                                onClick = { scope.launch {} },
                                interactionSource = MutableInteractionSource(),
                                indication = rememberRipple(bounded = true),
                            )
                            .padding(16.dp)
                            .fillMaxWidth(),
                    )
                }
            }
        }
    )
}
