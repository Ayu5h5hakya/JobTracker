package com.app.employeetracking.features.journey.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.employeetracking.features.journey.domain.viewmodel.JourneyViewModel

@Composable
fun Journey(modifier: Modifier = Modifier, viewModel: JourneyViewModel = hiltViewModel()) {
    val journey by viewModel.journey.collectAsState()

}