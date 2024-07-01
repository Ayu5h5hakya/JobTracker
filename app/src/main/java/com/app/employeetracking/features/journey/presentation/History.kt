package com.app.employeetracking.features.journey.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.app.employeetracking.R
import com.app.employeetracking.features.journey.presentation.components.HorizontalBar

@Composable
fun History(modifier: Modifier = Modifier) {
    Column(modifier) {
        Box(
            Modifier.background(
                color = colorResource(R.color.teal_200),
                shape = RoundedCornerShape(5.dp)
            )
        ) {
            HorizontalBar(Modifier.padding(horizontal = 10.dp, vertical = 10.dp))
        }

    }
}