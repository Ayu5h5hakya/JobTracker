package com.app.employeetracking.features.journey.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Journey(modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Journey", "History", "Holiday", "Requests")
    Column(modifier) {
        TabRow(modifier = Modifier.fillMaxWidth(),selectedTabIndex = currentIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(text = { Text(title) }, selected = index == currentIndex, onClick = {currentIndex = index})
            }
        }
    }
}