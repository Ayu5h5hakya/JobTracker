package com.app.employeetracking.features

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.app.employeetracking.features.auth.presentation.Login
import com.app.employeetracking.features.dashboard.presentation.Dashboard
import kotlinx.serialization.Serializable

//app routes
@Serializable
object Dashboard

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
    NavHost(
        navController = navController,
        startDestination = Dashboard,
    ) {
        navigation<Auth>(startDestination = Login) {
            composable<Login> { Login() }
            composable<Forgot> {  }
        }
        composable<Dashboard> { Dashboard() }
    }
}