package com.app.employeetracking.core.composables

import androidx.compose.foundation.clickable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionModal(
    modifier: Modifier = Modifier,
    options: List<String>,
    onOptionSelected: (option: String) -> Unit = {}
) {
    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    ModalBottomSheet(modifier = modifier, onDismissRequest = {}) {

        options.forEach { option ->
            Text(option, modifier = Modifier.clickable {
                scope.launch {
                    sheetState.hide()
                }.invokeOnCompletion {
                    onOptionSelected(option)
                }
            })
        }
    }
}