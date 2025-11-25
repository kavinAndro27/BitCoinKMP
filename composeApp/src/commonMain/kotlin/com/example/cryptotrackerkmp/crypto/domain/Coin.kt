package com.example.cryptotrackerkmp.crypto.domain

data class Coin(
    val id:String,
    val rank:String,
    val name:String,
    val symbol:String,
    val marketCap:Double,
    val marketCapCurrency:String,
    val price : Double,
    val priceCurrency:String,
    val changePercent24Hr:Double
)

