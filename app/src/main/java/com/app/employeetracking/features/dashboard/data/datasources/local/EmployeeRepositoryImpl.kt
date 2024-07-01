package com.app.employeetracking.features.dashboard.data.datasources.local

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.app.employeetracking.core.data.PreferencesKeys
import com.app.employeetracking.features.dashboard.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EmployeeRepositoryImpl @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : EmployeeRepository {
    override suspend fun saveToken(token: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.AUTH_TOKEN] = token
        }
    }

    override suspend fun saveLanguage(langCode: String) {
        dataStore.edit { preferences ->
            preferences[PreferencesKeys.LANGUAGE_CODE] = langCode
        }
    }

    override suspend fun isTokenValid(): Boolean {
        val token = dataStore.data.map { preferences ->
            preferences[PreferencesKeys.AUTH_TOKEN]
        }.first()
        return token != null
    }
}