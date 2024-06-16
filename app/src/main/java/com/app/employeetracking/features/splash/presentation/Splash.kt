package com.app.employeetracking.features.splash.presentation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.app.employeetracking.R

@Composable
fun Splash(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.splash),
        contentDescription = "splash screen for tracking app"
    )
}

