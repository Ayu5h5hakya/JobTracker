package com.app.employeetracking.features.journey.domain.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.app.employeetracking.core.data.Result
import com.app.employeetracking.features.journey.domain.model.Journey
import com.app.employeetracking.features.journey.domain.repository.JourneyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JourneyViewModel @Inject constructor(
    private val repository: JourneyRepository
) : ViewModel(){
    private var _journey = MutableStateFlow<Result<Journey>>(Result.Loading())
    val journey: StateFlow<Result<Journey>> = _journey.asStateFlow()

    init {
        viewModelScope.launch {
            getJourneyDetails()
        }
    }

    private suspend fun getJourneyDetails() {
        try {
            val journey = repository.getJourneyDetail()
            _journey.value = Result.Success(journey)
        } catch (e : Exception) {
            _journey.value = Result.Error(message = "Err")
        }
    }
}