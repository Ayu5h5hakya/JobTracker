package com.app.employeetracking.features.journey.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HorizontalBar(modifier: Modifier = Modifier) {
    val months = listOf("Jan","Feb","Mar","Apr","Jun","Jul","Aug","Sept","Oct","Nov","Dec")
    LazyRow(modifier) {
        items(months.size) { index ->
            Text(months[index], Modifier.padding(end = 20.dp))
        }
    }
}