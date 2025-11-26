package com.example.cryptotrackerkmp.crypto.domain

import com.example.cryptotrackerkmp.core.domain.util.Resource1

class GetCryptoAssetsUseCase(
    private val repository: CryptoListRepository
) {

    suspend operator fun invoke(): Resource1<List<Coin>> {
        return repository.getMockAssets()
    }

}