package com.app.employeetracking.features.dashboard.domain.repository

interface EmployeeRepository {
    suspend fun saveToken(token : String)
    suspend fun saveLanguage(langCode : String)
    suspend fun isTokenValid() : Boolean
}