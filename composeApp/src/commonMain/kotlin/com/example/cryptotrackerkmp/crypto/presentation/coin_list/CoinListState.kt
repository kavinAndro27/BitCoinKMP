package com.example.cryptotrackerkmp.crypto.presentation.coin_list

import androidx.compose.runtime.Immutable
import com.example.cryptotrackerkmp.crypto.presentation.models.CoinUi

@Immutable
data class CoinListState(
    val isLoading:Boolean = false,
    val coinList:List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi?=null,
    val errorMessage:String?=null
)
