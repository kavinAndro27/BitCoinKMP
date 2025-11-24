package com.example.cryptotrackerkmp.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext

enum class ContrastLevel { Default, Medium, High }

@Composable
fun AndroidCryptoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    contrast: ContrastLevel = ContrastLevel.High, // you’re using highContrast now
    content: @Composable () -> Unit
) {
    val context = LocalContext.current

    val colorScheme = remember(darkTheme, dynamicColor, contrast) {
        when {
            dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
                if (darkTheme) dynamicDarkColorScheme(context)
                else dynamicLightColorScheme(context)
            }

            darkTheme -> when (contrast) {
                ContrastLevel.Default -> darkScheme
                ContrastLevel.Medium  -> mediumContrastDarkColorScheme
                ContrastLevel.High    -> highContrastDarkColorScheme
            }

            else -> when (contrast) {
                ContrastLevel.Default -> lightScheme
                ContrastLevel.Medium  -> mediumContrastLightColorScheme
                ContrastLevel.High    -> highContrastLightColorScheme
            }
        }
    }

    AppTheme(
        colorScheme = colorScheme,
        content = content
    )
}