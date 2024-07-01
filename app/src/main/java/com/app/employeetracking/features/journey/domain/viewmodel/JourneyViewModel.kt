package com.app.employeetracking.features.journey.domain.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.employeetracking.core.Result
import com.app.employeetracking.features.journey.domain.model.Journey
import com.app.employeetracking.features.journey.domain.repository.JourneyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JourneyViewModel @Inject constructor(
    private val repository: JourneyRepository
) : ViewModel(){
    private var state by mutableStateOf<Result<Journey>>(Result.Loading())

    init {
        viewModelScope.launch {
            getJourneyDetails()
        }
    }

    private suspend fun getJourneyDetails() {
        try {
            val journey = repository.getJourneyDetail()
            state = Result.Success(journey)
        } catch (e : Exception) {
            state = Result.Error(message = "Err")
        }
    }
}