package com.example.cryptotrackerkmp.util

import platform.Foundation.NSNumberFormatter
import platform.Foundation.NSNumberFormatterDecimalStyle
import platform.Foundation.NSNumber

actual fun formatDouble(value: Double, fractionDigits: Int): String {
    val formatter = NSNumberFormatter().apply {
        numberStyle = NSNumberFormatterDecimalStyle
        minimumFractionDigits = fractionDigits.toULong()
        maximumFractionDigits = fractionDigits.toULong()
    }
    return formatter.stringFromNumber(NSNumber(value)) ?: value.toString()
}