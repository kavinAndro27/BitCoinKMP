package com.example.cryptotrackerkmp.crypto.presentation.models

import com.example.cryptotrackerkmp.crypto.domain.Coin
import com.example.cryptotrackerkmp.core.presentation.util.DisplayableNumber
import com.example.cryptotrackerkmp.core.presentation.util.getDrawableIdForCoin
import com.example.cryptotrackerkmp.core.presentation.util.toDisplayableNumber
import org.jetbrains.compose.resources.DrawableResource

data class CoinUi(
    val id:String,
    val rank:String,
    val name:String,
    val symbol:String,
    val marketCap: DisplayableNumber,
    val price: DisplayableNumber,
    val changePercent24Hr: DisplayableNumber,
    val iconRes: DrawableResource
)

fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        price = price.toDisplayableNumber(),
        marketCap = marketCap.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}