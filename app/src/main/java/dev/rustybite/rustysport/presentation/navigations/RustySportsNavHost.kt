package dev.rustybite.rustysport.presentation.navigations

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavArgs
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import dev.rustybite.rustysport.presentation.league_table_screen.LeagueTableScreen
import dev.rustybite.rustysport.presentation.ui.components.RustySportsBottomBar

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
            composable("home_screen") {
                LeagueTableScreen(
                    onNavigate = { event ->
                        navController.navigate(event.route)
                    },
                    onPopBackStack = {
                        navController.popBackStack()
                    }
                )
            }
            composable("games_screen") {}
            composable("profile_screen") {}
            composable("settings_screen") {}
            composable(
                "team/{teamId}",
                arguments = listOf(navArgument("teamId") { type = NavType.IntType})
            ) { navBackStackEntry ->
                val teamId = navBackStackEntry.arguments?.getInt("teamId")
                teamId?.let { 
                    Text(text = "Team Id is $it")
                }
            }
        }
    }
}