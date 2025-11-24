package com.example.cryptotrackerkmp.theme

import androidx.compose.runtime.Composable

enum class ContrastLevel { Default, Medium, High }

@Composable
fun IOSCryptoTheme(
    darkTheme: Boolean,
    contrast: ContrastLevel = ContrastLevel.High,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
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

    AppTheme(colorScheme, content)
}
