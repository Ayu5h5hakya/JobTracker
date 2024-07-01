package com.app.employeetracking.core.data

import androidx.datastore.preferences.core.stringPreferencesKey

object PreferencesKeys {
    val AUTH_TOKEN = stringPreferencesKey("auth_token")
    val LANGUAGE_CODE = stringPreferencesKey("lang_code")
}
