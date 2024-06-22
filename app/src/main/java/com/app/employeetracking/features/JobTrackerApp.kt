package com.app.employeetracking.features

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

//app routes
@Serializable
object Splash

@Serializable
object Dashboard

@Serializable
object Home

@Serializable
object Jobs

@Serializable
object Journey

@Serializable
object Trunk

@Serializable
object Profile

//auth routes
@Serializable
object Auth

@Serializable
object Login

@Serializable
object Forgot


@Composable
fun JobTrackerApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            DashboardBottomBar(
                onItemSelected = { index ->
                    if(index == 0) navController.navigate(route = Journey)
                    if(index == 1) navController.navigate(route = Jobs)
                    if(index == 2) navController.navigate(route = Home)
                    if(index == 3) navController.navigate(route = Trunk)
                    if(index == 4) navController.navigate(route = Profile)
                }
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Journey,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<Journey> { Text("journey") }
            composable<Jobs> { Text("Jobs") }
            composable<Home> { Text("Home") }
            composable<Trunk> { Text("Trunk") }
            composable<Profile> { Text("Profile") }
        }
    }
}

data class DashboardItem(
    val label: String,
    val icon: ImageVector
)

@Composable
fun DashboardBottomBar(modifier: Modifier = Modifier, onItemSelected: (Int) -> Unit = {}) {
    var selectedIndex by remember { mutableIntStateOf(0) }
    val items = listOf(
        DashboardItem(
            label = "Journey",
            icon = Icons.Default.PlayArrow
        ),
        DashboardItem(
            label = "Jobs",
            icon = Icons.Default.Build
        ),
        DashboardItem(
            label = "Home",
            icon = Icons.Default.Home
        ),
        DashboardItem(
            label = "Trunk",
            icon = Icons.Default.Menu
        ),
        DashboardItem(
            label = "Profile",
            icon = Icons.Default.Person
        ),
    )
    NavigationBar {
        items.forEachIndexed { index, dashboardItem ->
            NavigationBarItem(
                selected = selectedIndex == index,
                onClick = {
                    selectedIndex = index
                    onItemSelected(index)
                },
                icon = {
                    Icon(
                        imageVector = items[index].icon,
                        contentDescription = items[index].label
                    )
                }
            )
        }
    }
}