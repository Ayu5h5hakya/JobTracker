package com.app.employeetracking.features.journey.domain.repository

import com.app.employeetracking.core.Result
import com.app.employeetracking.features.journey.domain.model.Journey

interface JourneyRepository {
    suspend fun getJourneyDetail(): Journey
}