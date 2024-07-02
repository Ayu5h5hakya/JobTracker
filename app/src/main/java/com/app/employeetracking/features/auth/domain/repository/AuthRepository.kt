package com.app.employeetracking.features.auth.domain.repository

interface AuthRepository {
    suspend fun login()
}