package com.example.cryptotrackerkmp.core.domain.util

import android.icu.text.NumberFormat
import java.util.Locale

actual fun formatDouble(value: Double, fractionDigits: Int): String {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = fractionDigits
        maximumFractionDigits = fractionDigits
    }
    return formatter.format(value)
}