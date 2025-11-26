package com.example.cryptotrackerkmp.core.presentation.util

import com.example.cryptotrackerkmp.core.domain.util.formatDouble


data class DisplayableNumber(
    val value: Double,
    val formatted: String
)


fun Double.toDisplayableNumber(): DisplayableNumber {
    return DisplayableNumber(
        value = this,
        formatted = formatDouble(this, 2)
    )
}
