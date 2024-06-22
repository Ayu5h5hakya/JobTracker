package com.app.employeetracking.features.dashboard.presentation

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.serialization.Serializable

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

@Composable
fun Dashboard(modifier: Modifier = Modifier) {
    var currentPageIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        bottomBar = {
            DashboardBottomBar(
                onItemSelected = { index ->
                    currentPageIndex = index

                }
            )
        }
    ) { innerPadding ->
        val padding = innerPadding

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