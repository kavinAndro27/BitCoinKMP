package com.example.cryptotrackerkmp.crypto.domain

import com.example.cryptotrackerkmp.core.domain.util.Resource1

interface CryptoListRepository {
    suspend fun getAssets(): Resource1<List<Coin>>
    suspend fun getMockAssets(): Resource1<List<Coin>>
}