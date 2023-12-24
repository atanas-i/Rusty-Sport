package dev.rustybite.rustysport.presentation.navigations

import dev.rustybite.rustysport.R

sealed class BottomBarItem(
    val route: String,
    val item: String,
    val selectedIcon: Int,
    val unselectedIcon: Int,
    val hasInfo: Boolean = false,
    val badgeCount: Int? = null
) {
    data object Home : BottomBarItem(
        route = "home_screen",
        item = "Home",
        selectedIcon = R.drawable.home_filled_icon,
        unselectedIcon = R.drawable.home_outlined_icon
    )
    data object Games : BottomBarItem(
        route = "games_screen",
        item = "Games",
        selectedIcon = R.drawable.football_icon,
        unselectedIcon = R.drawable.football_icon,
    )
    data object Profile : BottomBarItem(
        route = "profile_screen",
        item = "Profile",
        selectedIcon = R.drawable.profile_filled_icon,
        unselectedIcon = R.drawable.profile_outlined_icon
    )
    data object Settings : BottomBarItem(
        route = "settings_screen",
        item = "Settings",
        selectedIcon = R.drawable.setting_filled_icon,
        unselectedIcon = R.drawable.setting_outlined_icon,
    )
}

val bottomBarItems = listOf(
    BottomBarItem.Home,
    BottomBarItem.Games,
    BottomBarItem.Profile,
    BottomBarItem.Settings
)