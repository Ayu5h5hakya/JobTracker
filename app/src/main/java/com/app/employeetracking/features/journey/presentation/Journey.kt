package com.app.employeetracking.features.journey.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.employeetracking.core.data.Result
import com.app.employeetracking.features.journey.domain.viewmodel.JourneyViewModel

@Composable
fun Journey(modifier: Modifier = Modifier, viewModel: JourneyViewModel = hiltViewModel()) {
    val journey by viewModel.journey.collectAsState()
    when (journey) {
        is Result.Loading -> {
            Text("loading")
        }

        is Result.Success -> {
            Text("Data")
        }

        else -> {
            Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column (horizontalAlignment = Alignment.CenterHorizontally){
                    Icon(imageVector = Icons.Default.Info, contentDescription = null)
                    Text("Something went wrong. Please try again later.")
                }
            }
        }
    }
}