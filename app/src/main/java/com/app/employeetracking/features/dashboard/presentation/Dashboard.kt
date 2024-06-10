package com.app.employeetracking.features.dashboard.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.employeetracking.features.home.presentation.Home
import com.app.employeetracking.features.jobs.presentation.Jobs
import com.app.employeetracking.features.journey.presentation.Journey
import com.app.employeetracking.features.profile.presentation.Profile
import com.app.employeetracking.features.trunk.presentation.Trunk
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(modifier: Modifier = Modifier) {
    var currentPageIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        when (currentPageIndex) {
                            0 -> "My Journey"
                            1 -> "Jobs"
                            2 -> "Home"
                            3 -> "Trunk"
                            4 -> "profile"
                            else -> ""
                        }
                    )
                },
            )
        },
        bottomBar = {
            DashboardBottomBar(
                onItemSelected = { index ->
                    currentPageIndex = index

                }
            )
        }
    ) { innerPadding ->
        when (currentPageIndex) {
            0 -> Journey(Modifier.padding(innerPadding))
            1 -> Jobs(Modifier.padding(innerPadding))
            2 -> Home(Modifier.padding(innerPadding))
            3 -> Trunk(Modifier.padding(innerPadding))
            4 -> Profile(Modifier.padding(innerPadding))
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