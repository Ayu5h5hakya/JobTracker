package com.app.employeetracking.features.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.app.employeetracking.R
import kotlinx.coroutines.delay

@Composable
fun Splash(modifier: Modifier = Modifier, gotoLogin: () -> Unit = {}) {
    Image(
        painter = painterResource(R.drawable.splash),
        contentDescription = "splash screen for tracking app"
    )
    LaunchedEffect(Unit) {
        delay(3000L)
        gotoLogin()
    }
}

