package com.dicoding.picodiploma.kbt_project.Component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val title : String,
    val route : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector
)

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route = "home_dashboard",
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
    ),
    BottomNavItem(
        title = "Patient",
        route = "patient_screen",
        selectedIcon = Icons.Filled.Face,
        unselectedIcon = Icons.Outlined.Face,
    ),
    BottomNavItem(
        title = "Profile",
        route = "profile_page",
        selectedIcon = Icons.Filled.Person,
        unselectedIcon = Icons.Outlined.Person,
    )
)
