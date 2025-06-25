package com.rafihidayat.digitalent.ui.theme.red
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.rafi607062330092.assesment2.ui.theme.red.backgroundDark
import com.rafi607062330092.assesment2.ui.theme.red.backgroundDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.backgroundDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.backgroundLight
import com.rafi607062330092.assesment2.ui.theme.red.backgroundLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.backgroundLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.errorContainerDark
import com.rafi607062330092.assesment2.ui.theme.red.errorContainerDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.errorContainerDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.errorContainerLight
import com.rafi607062330092.assesment2.ui.theme.red.errorContainerLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.errorContainerLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.errorDark
import com.rafi607062330092.assesment2.ui.theme.red.errorDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.errorDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.errorLight
import com.rafi607062330092.assesment2.ui.theme.red.errorLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.errorLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.inverseOnSurfaceDark
import com.rafi607062330092.assesment2.ui.theme.red.inverseOnSurfaceDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.inverseOnSurfaceDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.inverseOnSurfaceLight
import com.rafi607062330092.assesment2.ui.theme.red.inverseOnSurfaceLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.inverseOnSurfaceLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.inversePrimaryDark
import com.rafi607062330092.assesment2.ui.theme.red.inversePrimaryDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.inversePrimaryDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.inversePrimaryLight
import com.rafi607062330092.assesment2.ui.theme.red.inversePrimaryLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.inversePrimaryLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.inverseSurfaceDark
import com.rafi607062330092.assesment2.ui.theme.red.inverseSurfaceDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.inverseSurfaceDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.inverseSurfaceLight
import com.rafi607062330092.assesment2.ui.theme.red.inverseSurfaceLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.inverseSurfaceLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onBackgroundDark
import com.rafi607062330092.assesment2.ui.theme.red.onBackgroundDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onBackgroundDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onBackgroundLight
import com.rafi607062330092.assesment2.ui.theme.red.onBackgroundLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onBackgroundLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onErrorContainerDark
import com.rafi607062330092.assesment2.ui.theme.red.onErrorContainerDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onErrorContainerDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onErrorContainerLight
import com.rafi607062330092.assesment2.ui.theme.red.onErrorContainerLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onErrorContainerLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onErrorDark
import com.rafi607062330092.assesment2.ui.theme.red.onErrorDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onErrorDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onErrorLight
import com.rafi607062330092.assesment2.ui.theme.red.onErrorLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onErrorLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryContainerDark
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryContainerDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryContainerDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryContainerLight
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryContainerLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryContainerLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryDark
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryLight
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onPrimaryLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryContainerDark
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryContainerDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryContainerDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryContainerLight
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryContainerLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryContainerLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryDark
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryLight
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSecondaryLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceDark
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceLight
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceVariantDark
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceVariantDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceVariantDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceVariantLight
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceVariantLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onSurfaceVariantLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryContainerDark
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryContainerDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryContainerDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryContainerLight
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryContainerLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryContainerLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryDark
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryLight
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.onTertiaryLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.outlineDark
import com.rafi607062330092.assesment2.ui.theme.red.outlineDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.outlineDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.outlineLight
import com.rafi607062330092.assesment2.ui.theme.red.outlineLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.outlineLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.outlineVariantDark
import com.rafi607062330092.assesment2.ui.theme.red.outlineVariantDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.outlineVariantDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.outlineVariantLight
import com.rafi607062330092.assesment2.ui.theme.red.outlineVariantLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.outlineVariantLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.primaryContainerDark
import com.rafi607062330092.assesment2.ui.theme.red.primaryContainerDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.primaryContainerDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.primaryContainerLight
import com.rafi607062330092.assesment2.ui.theme.red.primaryContainerLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.primaryContainerLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.primaryDark
import com.rafi607062330092.assesment2.ui.theme.red.primaryDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.primaryDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.primaryLight
import com.rafi607062330092.assesment2.ui.theme.red.primaryLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.primaryLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.scrimDark
import com.rafi607062330092.assesment2.ui.theme.red.scrimDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.scrimDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.scrimLight
import com.rafi607062330092.assesment2.ui.theme.red.scrimLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.scrimLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.secondaryContainerDark
import com.rafi607062330092.assesment2.ui.theme.red.secondaryContainerDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.secondaryContainerDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.secondaryContainerLight
import com.rafi607062330092.assesment2.ui.theme.red.secondaryContainerLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.secondaryContainerLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.secondaryDark
import com.rafi607062330092.assesment2.ui.theme.red.secondaryDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.secondaryDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.secondaryLight
import com.rafi607062330092.assesment2.ui.theme.red.secondaryLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.secondaryLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceBrightDark
import com.rafi607062330092.assesment2.ui.theme.red.surfaceBrightDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceBrightDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceBrightLight
import com.rafi607062330092.assesment2.ui.theme.red.surfaceBrightLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceBrightLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerDark
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighDark
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighLight
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighestDark
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighestDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighestDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighestLight
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighestLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerHighestLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLight
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowDark
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowLight
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowestDark
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowestDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowestDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowestLight
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowestLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceContainerLowestLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceDark
import com.rafi607062330092.assesment2.ui.theme.red.surfaceDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceDimDark
import com.rafi607062330092.assesment2.ui.theme.red.surfaceDimDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceDimDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceDimLight
import com.rafi607062330092.assesment2.ui.theme.red.surfaceDimLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceDimLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceLight
import com.rafi607062330092.assesment2.ui.theme.red.surfaceLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceVariantDark
import com.rafi607062330092.assesment2.ui.theme.red.surfaceVariantDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceVariantDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceVariantLight
import com.rafi607062330092.assesment2.ui.theme.red.surfaceVariantLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.surfaceVariantLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryContainerDark
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryContainerDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryContainerDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryContainerLight
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryContainerLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryContainerLightMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryDark
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryDarkHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryDarkMediumContrast
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryLight
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryLightHighContrast
import com.rafi607062330092.assesment2.ui.theme.red.tertiaryLightMediumContrast

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
    surfaceDim = surfaceDimLight,
    surfaceBright = surfaceBrightLight,
    surfaceContainerLowest = surfaceContainerLowestLight,
    surfaceContainerLow = surfaceContainerLowLight,
    surfaceContainer = surfaceContainerLight,
    surfaceContainerHigh = surfaceContainerHighLight,
    surfaceContainerHighest = surfaceContainerHighestLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
    surfaceDim = surfaceDimDark,
    surfaceBright = surfaceBrightDark,
    surfaceContainerLowest = surfaceContainerLowestDark,
    surfaceContainerLow = surfaceContainerLowDark,
    surfaceContainer = surfaceContainerDark,
    surfaceContainerHigh = surfaceContainerHighDark,
    surfaceContainerHighest = surfaceContainerHighestDark,
)

private val mediumContrastLightColorScheme = lightColorScheme(
    primary = primaryLightMediumContrast,
    onPrimary = onPrimaryLightMediumContrast,
    primaryContainer = primaryContainerLightMediumContrast,
    onPrimaryContainer = onPrimaryContainerLightMediumContrast,
    secondary = secondaryLightMediumContrast,
    onSecondary = onSecondaryLightMediumContrast,
    secondaryContainer = secondaryContainerLightMediumContrast,
    onSecondaryContainer = onSecondaryContainerLightMediumContrast,
    tertiary = tertiaryLightMediumContrast,
    onTertiary = onTertiaryLightMediumContrast,
    tertiaryContainer = tertiaryContainerLightMediumContrast,
    onTertiaryContainer = onTertiaryContainerLightMediumContrast,
    error = errorLightMediumContrast,
    onError = onErrorLightMediumContrast,
    errorContainer = errorContainerLightMediumContrast,
    onErrorContainer = onErrorContainerLightMediumContrast,
    background = backgroundLightMediumContrast,
    onBackground = onBackgroundLightMediumContrast,
    surface = surfaceLightMediumContrast,
    onSurface = onSurfaceLightMediumContrast,
    surfaceVariant = surfaceVariantLightMediumContrast,
    onSurfaceVariant = onSurfaceVariantLightMediumContrast,
    outline = outlineLightMediumContrast,
    outlineVariant = outlineVariantLightMediumContrast,
    scrim = scrimLightMediumContrast,
    inverseSurface = inverseSurfaceLightMediumContrast,
    inverseOnSurface = inverseOnSurfaceLightMediumContrast,
    inversePrimary = inversePrimaryLightMediumContrast,
    surfaceDim = surfaceDimLightMediumContrast,
    surfaceBright = surfaceBrightLightMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestLightMediumContrast,
    surfaceContainerLow = surfaceContainerLowLightMediumContrast,
    surfaceContainer = surfaceContainerLightMediumContrast,
    surfaceContainerHigh = surfaceContainerHighLightMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestLightMediumContrast,
)

private val highContrastLightColorScheme = lightColorScheme(
    primary = primaryLightHighContrast,
    onPrimary = onPrimaryLightHighContrast,
    primaryContainer = primaryContainerLightHighContrast,
    onPrimaryContainer = onPrimaryContainerLightHighContrast,
    secondary = secondaryLightHighContrast,
    onSecondary = onSecondaryLightHighContrast,
    secondaryContainer = secondaryContainerLightHighContrast,
    onSecondaryContainer = onSecondaryContainerLightHighContrast,
    tertiary = tertiaryLightHighContrast,
    onTertiary = onTertiaryLightHighContrast,
    tertiaryContainer = tertiaryContainerLightHighContrast,
    onTertiaryContainer = onTertiaryContainerLightHighContrast,
    error = errorLightHighContrast,
    onError = onErrorLightHighContrast,
    errorContainer = errorContainerLightHighContrast,
    onErrorContainer = onErrorContainerLightHighContrast,
    background = backgroundLightHighContrast,
    onBackground = onBackgroundLightHighContrast,
    surface = surfaceLightHighContrast,
    onSurface = onSurfaceLightHighContrast,
    surfaceVariant = surfaceVariantLightHighContrast,
    onSurfaceVariant = onSurfaceVariantLightHighContrast,
    outline = outlineLightHighContrast,
    outlineVariant = outlineVariantLightHighContrast,
    scrim = scrimLightHighContrast,
    inverseSurface = inverseSurfaceLightHighContrast,
    inverseOnSurface = inverseOnSurfaceLightHighContrast,
    inversePrimary = inversePrimaryLightHighContrast,
    surfaceDim = surfaceDimLightHighContrast,
    surfaceBright = surfaceBrightLightHighContrast,
    surfaceContainerLowest = surfaceContainerLowestLightHighContrast,
    surfaceContainerLow = surfaceContainerLowLightHighContrast,
    surfaceContainer = surfaceContainerLightHighContrast,
    surfaceContainerHigh = surfaceContainerHighLightHighContrast,
    surfaceContainerHighest = surfaceContainerHighestLightHighContrast,
)

private val mediumContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkMediumContrast,
    onPrimary = onPrimaryDarkMediumContrast,
    primaryContainer = primaryContainerDarkMediumContrast,
    onPrimaryContainer = onPrimaryContainerDarkMediumContrast,
    secondary = secondaryDarkMediumContrast,
    onSecondary = onSecondaryDarkMediumContrast,
    secondaryContainer = secondaryContainerDarkMediumContrast,
    onSecondaryContainer = onSecondaryContainerDarkMediumContrast,
    tertiary = tertiaryDarkMediumContrast,
    onTertiary = onTertiaryDarkMediumContrast,
    tertiaryContainer = tertiaryContainerDarkMediumContrast,
    onTertiaryContainer = onTertiaryContainerDarkMediumContrast,
    error = errorDarkMediumContrast,
    onError = onErrorDarkMediumContrast,
    errorContainer = errorContainerDarkMediumContrast,
    onErrorContainer = onErrorContainerDarkMediumContrast,
    background = backgroundDarkMediumContrast,
    onBackground = onBackgroundDarkMediumContrast,
    surface = surfaceDarkMediumContrast,
    onSurface = onSurfaceDarkMediumContrast,
    surfaceVariant = surfaceVariantDarkMediumContrast,
    onSurfaceVariant = onSurfaceVariantDarkMediumContrast,
    outline = outlineDarkMediumContrast,
    outlineVariant = outlineVariantDarkMediumContrast,
    scrim = scrimDarkMediumContrast,
    inverseSurface = inverseSurfaceDarkMediumContrast,
    inverseOnSurface = inverseOnSurfaceDarkMediumContrast,
    inversePrimary = inversePrimaryDarkMediumContrast,
    surfaceDim = surfaceDimDarkMediumContrast,
    surfaceBright = surfaceBrightDarkMediumContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkMediumContrast,
    surfaceContainerLow = surfaceContainerLowDarkMediumContrast,
    surfaceContainer = surfaceContainerDarkMediumContrast,
    surfaceContainerHigh = surfaceContainerHighDarkMediumContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkMediumContrast,
)

private val highContrastDarkColorScheme = darkColorScheme(
    primary = primaryDarkHighContrast,
    onPrimary = onPrimaryDarkHighContrast,
    primaryContainer = primaryContainerDarkHighContrast,
    onPrimaryContainer = onPrimaryContainerDarkHighContrast,
    secondary = secondaryDarkHighContrast,
    onSecondary = onSecondaryDarkHighContrast,
    secondaryContainer = secondaryContainerDarkHighContrast,
    onSecondaryContainer = onSecondaryContainerDarkHighContrast,
    tertiary = tertiaryDarkHighContrast,
    onTertiary = onTertiaryDarkHighContrast,
    tertiaryContainer = tertiaryContainerDarkHighContrast,
    onTertiaryContainer = onTertiaryContainerDarkHighContrast,
    error = errorDarkHighContrast,
    onError = onErrorDarkHighContrast,
    errorContainer = errorContainerDarkHighContrast,
    onErrorContainer = onErrorContainerDarkHighContrast,
    background = backgroundDarkHighContrast,
    onBackground = onBackgroundDarkHighContrast,
    surface = surfaceDarkHighContrast,
    onSurface = onSurfaceDarkHighContrast,
    surfaceVariant = surfaceVariantDarkHighContrast,
    onSurfaceVariant = onSurfaceVariantDarkHighContrast,
    outline = outlineDarkHighContrast,
    outlineVariant = outlineVariantDarkHighContrast,
    scrim = scrimDarkHighContrast,
    inverseSurface = inverseSurfaceDarkHighContrast,
    inverseOnSurface = inverseOnSurfaceDarkHighContrast,
    inversePrimary = inversePrimaryDarkHighContrast,
    surfaceDim = surfaceDimDarkHighContrast,
    surfaceBright = surfaceBrightDarkHighContrast,
    surfaceContainerLowest = surfaceContainerLowestDarkHighContrast,
    surfaceContainerLow = surfaceContainerLowDarkHighContrast,
    surfaceContainer = surfaceContainerDarkHighContrast,
    surfaceContainerHigh = surfaceContainerHighDarkHighContrast,
    surfaceContainerHighest = surfaceContainerHighestDarkHighContrast,
)

@Immutable
data class ColorFamily(
    val color: Color,
    val onColor: Color,
    val colorContainer: Color,
    val onColorContainer: Color
)

val unspecified_scheme = ColorFamily(
    Color.Unspecified, Color.Unspecified, Color.Unspecified, Color.Unspecified
)

@Composable
fun RedTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable() () -> Unit
) {
  val colorScheme = when {
      dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
          val context = LocalContext.current
          if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
      }
      
      darkTheme -> darkScheme
      else -> lightScheme
  }

  MaterialTheme(
    colorScheme = colorScheme,
    typography = AppTypography,
    content = content
  )
}

