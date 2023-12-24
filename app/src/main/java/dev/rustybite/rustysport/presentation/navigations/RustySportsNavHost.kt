package dev.rustybite.rustysport.presentation.navigations

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.rustybite.rustysport.ui.components.RustySportsBottomBar

@Composable
fun RustySportsNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        bottomBar = {
            RustySportsBottomBar(navHostController = navController)
        }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "home_screen",
            modifier = modifier
                .padding(paddingValues)
        ) {
            composable("home_screen") {}
            composable("games_screen") {}
            composable("profile_screen") {}
            composable("settings_screen") {}
        }
    }
}