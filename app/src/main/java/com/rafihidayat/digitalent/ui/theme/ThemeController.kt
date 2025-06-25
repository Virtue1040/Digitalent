package com.rafihidayat.digitalent.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import com.rafihidayat.digitalent.ui.theme.normal.DefaultTheme
import com.rafihidayat.digitalent.ui.theme.red.RedTheme
import com.rafihidayat.digitalent.util.SettingsDataStore

@Composable
fun ThemeController(
    content: @Composable () -> Unit
) {
    val dataStore = SettingsDataStore(LocalContext.current)
    val theme by dataStore.themeFlow.collectAsState(true)

    when (theme) {
        true -> {
            DefaultTheme {
                content()
            }
        }
        false -> {
            RedTheme {
                content()
            }
        }
    }
}