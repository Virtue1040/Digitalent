package com.rafihidayat.digitalent.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.rafihidayat.digitalent.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(
    name = "user_preference"
)

class UserDataStore(private val context: Context) {
    companion object {
        private val USER_ID = longPreferencesKey("id")
        private val USER_NAME = stringPreferencesKey("username")
        private val USER_FULL_NAME = stringPreferencesKey("fullName")
        private val USER_PASSWORD = stringPreferencesKey("password")
    }

    val userFlow: Flow<User> = context.dataStore.data.map { preferences ->
        User(
            id = preferences[USER_ID] ?: 0L,
            username = preferences[USER_NAME] ?: "",
            fullName = preferences[USER_FULL_NAME] ?: "",
            password = preferences[USER_PASSWORD] ?: ""
        )
    }

    suspend fun saveData(user: User) {
        context.dataStore.edit { preferences ->
            preferences[USER_ID] = user.id
            preferences[USER_NAME] = user.username
            preferences[USER_FULL_NAME] = user.fullName
            preferences[USER_PASSWORD] = user.password
        }
    }
}