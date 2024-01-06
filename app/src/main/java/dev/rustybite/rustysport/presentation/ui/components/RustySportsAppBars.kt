package dev.rustybite.rustysport.presentation.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import coil.compose.AsyncImage
import coil.request.ImageRequest
import dev.rustybite.rustysport.R
import dev.rustybite.rustysport.presentation.navigations.bottomBarItems

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RustySportsBottomBar(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
    containerColor: Color = MaterialTheme.colorScheme.surfaceVariant
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


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RustySportsTopBar(
    title: String,
    logoUrl: String,
    modifier: Modifier = Modifier,
    navigationIcon: Int,
    navIconContentDescription: String,
    onNavigationIconClicked: () -> Unit,
    onLogoClocked: () -> Unit,
    containerColor: Color = MaterialTheme.colorScheme.surfaceVariant,
) {

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                fontSize = 22.sp

            )
        },
        navigationIcon = {
            IconButton(onClick = onNavigationIconClicked) {
                Icon(
                    painter = painterResource(id = navigationIcon),
                    contentDescription = navIconContentDescription,
                    modifier = modifier
                        .size(dimensionResource(id = R.dimen.rs_icon_size_medium))
                )
            }
        },
        actions = {
            IconButton(
                onClick = onLogoClocked,
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(
                        LocalContext.current
                    ).data(logoUrl)
                        .crossfade(enable = true)
                        .crossfade(durationMillis = 1000)
                        .build(),
                    contentDescription = "League logo",
                    modifier = modifier
                        .size(dimensionResource(id = R.dimen.rs_team_logo_size_large))
                        .clip(CircleShape)
                        .background(Color.White)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
            titleContentColor = MaterialTheme.colorScheme.onSurfaceVariant,
            navigationIconContentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        windowInsets = WindowInsets(top = 0.dp, bottom = 0.dp)
    )
}