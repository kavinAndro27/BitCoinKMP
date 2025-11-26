package com.example.cryptotrackerkmp.crypto.data

import com.example.cryptotrackerkmp.crypto.domain.Coin

fun DataItem.toDomain(): Coin {
    return Coin(
        id = id.orEmpty(),
        rank = rank.orEmpty(),
        name = name.orEmpty(),
        symbol = symbol.orEmpty(),

        // Convert strings to doubles safely
        marketCap = marketCapUsd?.toDoubleOrNull() ?: 0.0,
        marketCapCurrency = "USD",

        price = priceUsd?.toDoubleOrNull() ?: 0.0,
        priceCurrency = "USD",

        changePercent24Hr = changePercent24Hr?.toDoubleOrNull() ?: 0.0
    )
}