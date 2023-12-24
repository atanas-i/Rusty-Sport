package dev.rustybite.rustysport.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.rustybite.rustysport.R
import dev.rustybite.rustysport.presentation.navigations.bottomBarItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RustySportsBottomBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surface
) {
    val navBackStackEntry = navHostController.currentBackStackEntryAsState().value
    val currentRoute = navBackStackEntry?.destination?.route
    NavigationBar(
        containerColor = containerColor
    ) {
        bottomBarItems.forEach { item ->
            NavigationBarItem(
                selected = item.route == currentRoute,
                onClick = {
                    navHostController.navigate(item.route) {
                        popUpTo(navHostController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                          },
                icon = { 
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasInfo) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            painter = if (item.route == currentRoute)
                                painterResource(id = item.selectedIcon) else
                                painterResource(id = item.unselectedIcon),
                            contentDescription = item.item,
                            modifier = modifier
                                .size(dimensionResource(id = R.dimen.rs_icon_size_medium))
                        )
                    }
                },
                label = {
                    Text(text = item.item)
                }
            )
        }
    }
}