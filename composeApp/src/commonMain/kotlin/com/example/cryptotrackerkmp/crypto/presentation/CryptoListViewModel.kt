package com.example.cryptotrackerkmp.crypto.presentation

import androidx.lifecycle.ViewModel
import com.example.cryptotrackerkmp.core.domain.util.Resource1
import com.example.cryptotrackerkmp.crypto.domain.GetCryptoAssetsUseCase
import com.example.cryptotrackerkmp.crypto.presentation.coin_list.CoinListState
import com.example.cryptotrackerkmp.crypto.presentation.models.toCoinUi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoListViewModel(
    private val getCryptoAssetsUseCase: GetCryptoAssetsUseCase,
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.Default)
): ViewModel() {

    private val _uiState = MutableStateFlow(CoinListState())
    val uiState: StateFlow<CoinListState> = _uiState

    fun loadAssets() {
        _uiState.value = CoinListState(isLoading = true)

        coroutineScope.launch {
            when (val result = getCryptoAssetsUseCase()) {
                is Resource1.Success -> {
                    _uiState.value = CoinListState(
                        isLoading = false,
                        coinList = result.data.map {
                            it.toCoinUi()
                        }
                    )
                }

                is Resource1.Error -> {
                    _uiState.value = CoinListState(
                        isLoading = false,
                        errorMessage = result.message
                    )
                }
            }
        }
    }

}