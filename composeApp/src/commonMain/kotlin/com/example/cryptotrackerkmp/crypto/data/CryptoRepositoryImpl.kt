package com.example.cryptotrackerkmp.crypto.data

import com.example.cryptotrackerkmp.core.domain.util.Resource1
import com.example.cryptotrackerkmp.crypto.domain.Coin
import com.example.cryptotrackerkmp.crypto.domain.CryptoListRepository

class CryptoListRepositoryImpl(
    private val api: CoinCapApi
): CryptoListRepository {
    override suspend fun getAssets(): Resource1<List<Coin>> {
        return when (val result = api.getAssets()) {
            is Resource1.Success -> {
                val list: List<Coin> = result.data.data
                    ?.filterNotNull()
                    ?.map { it.toDomain() }
                    .orEmpty()

                Resource1.Success(list)
            }

            is Resource1.Error -> {
                Resource1.Error(result.message, result.code)
            }
        }
    }

    override suspend fun getMockAssets(): Resource1<List<Coin>> {
        return Resource1.Success(mockCoins)
    }
}

val mockCoins = listOf(
    Coin("bitcoin", "1", "Bitcoin", "BTC", 850_000_000_000.0, "USD", 43_250.75, "USD", 1.25),
    Coin("ethereum", "2", "Ethereum", "ETH", 390_000_000_000.0, "USD", 2_320.10, "USD", -0.85),
    Coin("tether", "3", "Tether", "USDT", 95_000_000_000.0, "USD", 1.00, "USD", 0.01),
    Coin("binancecoin", "4", "BNB", "BNB", 50_000_000_000.0, "USD", 318.55, "USD", 0.45),
    Coin("solana", "5", "Solana", "SOL", 45_000_000_000.0, "USD", 102.40, "USD", 2.10),
    Coin("ripple", "6", "XRP", "XRP", 28_000_000_000.0, "USD", 0.52, "USD", -1.15),
    Coin("usd-coin", "7", "USD Coin", "USDC", 26_000_000_000.0, "USD", 1.00, "USD", 0.00),
    Coin("cardano", "8", "Cardano", "ADA", 15_000_000_000.0, "USD", 0.42, "USD", 0.71),
    Coin("dogecoin", "9", "Dogecoin", "DOGE", 13_500_000_000.0, "USD", 0.095, "USD", -0.45),
    Coin("avalanche", "10", "Avalanche", "AVAX", 12_000_000_000.0, "USD", 32.50, "USD", 3.11),
    Coin("polkadot", "11", "Polkadot", "DOT", 10_500_000_000.0, "USD", 7.80, "USD", -0.90),
    Coin("tron", "12", "TRON", "TRX", 9_500_000_000.0, "USD", 0.12, "USD", 0.28),
    Coin("chainlink", "13", "Chainlink", "LINK", 8_400_000_000.0, "USD", 14.75, "USD", 2.80),
    Coin("polygon", "14", "Polygon", "MATIC", 7_900_000_000.0, "USD", 0.88, "USD", 1.05),
    Coin("litecoin", "15", "Litecoin", "LTC", 6_700_000_000.0, "USD", 92.15, "USD", -0.63),
    Coin("shiba-inu", "16", "Shiba Inu", "SHIB", 5_800_000_000.0, "USD", 0.000009, "USD", 1.50),
    Coin("uniswap", "17", "Uniswap", "UNI", 5_200_000_000.0, "USD", 6.15, "USD", 0.44),
    Coin("cosmos", "18", "Cosmos", "ATOM", 4_800_000_000.0, "USD", 9.72, "USD", 1.90),
    Coin("stellar", "19", "Stellar", "XLM", 4_400_000_000.0, "USD", 0.11, "USD", -0.32),
    Coin("monero", "20", "Monero", "XMR", 3_900_000_000.0, "USD", 165.20, "USD", 0.70)
)
