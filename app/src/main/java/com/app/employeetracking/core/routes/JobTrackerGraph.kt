package com.app.employeetracking.core.routes

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.app.employeetracking.features.auth.presentation.Login
import com.app.employeetracking.features.splash.presentation.Splash
import kotlinx.serialization.Serializable

//app routes
@Serializable
object Splash
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
fun JobTrackerGraph() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Splash) {
        composable<Splash> { Splash(gotoLogin = {navController.navigate(route = Auth)}) }
        navigation<Auth>(startDestination = Login) {
            composable<Login> {
                Login()
            }
            composable<Forgot> { }
        }
    }
}