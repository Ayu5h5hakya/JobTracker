package com.app.employeetracking.features.auth.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.app.employeetracking.R

@Composable
fun Login(modifier: Modifier = Modifier) {
    Surface(modifier.fillMaxSize(), color = MaterialTheme.colorScheme.outlineVariant) {
        Box {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.align(
                    Alignment.TopCenter
                )
            )
            Image(
                painter = painterResource(R.drawable.login_graphic),
                contentDescription = null,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
    }
}