package com.example.cryptotrackerkmp.util


data class DisplayableNumber(
    val value: Double,
    val formatted: String
)

expect fun formatDouble(value: Double, fractionDigits: Int = 2): String

fun Double.toDisplayableNumber(): DisplayableNumber {
    return DisplayableNumber(
        value = this,
        formatted = formatDouble(this, 2)
    )
}
