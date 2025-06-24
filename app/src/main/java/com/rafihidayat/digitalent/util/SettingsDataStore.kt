package com.rafihidayat.digitalent.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(
    name = "settings_preference"
)

class SettingsDataStore(private val context: Context) {
    companion object {
        private val IS_LIST = booleanPreferencesKey("is_list")
        private val IS_THEME = booleanPreferencesKey("is_theme")
    }

    val layoutFlow: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_LIST] ?: true
    }
    val themeFlow: Flow<Boolean> = context.dataStore.data.map { preferences ->
        preferences[IS_THEME] ?: true
    }

    suspend fun saveLayout(isList: Boolean) {
        context.dataStore.edit {
            preferences -> preferences[IS_LIST] = isList
        }
    }

    suspend fun saveTheme(isTheme: Boolean) {
        context.dataStore.edit {
            preferences -> preferences[IS_THEME] = isTheme
        }
    }
}