package com.example.cryptotrackerkmp.crypto.presentation.coin_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.cryptotrackerkmp.crypto.data.CoinCapApi
import com.example.cryptotrackerkmp.crypto.data.CryptoListRepositoryImpl
import com.example.cryptotrackerkmp.crypto.domain.GetCryptoAssetsUseCase
import com.example.cryptotrackerkmp.crypto.presentation.CryptoListViewModel
import com.example.cryptotrackerkmp.crypto.presentation.coin_list.components.CoinListItem
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CoinListScreen() {


    val viewModel = remember {
        val api = CoinCapApi()
        val repo = CryptoListRepositoryImpl(api)
        val useCase = GetCryptoAssetsUseCase(repo)
        CryptoListViewModel(useCase)
    }

    val state by viewModel.uiState.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.loadAssets()
    }

    if (state.isLoading){
        Box(modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center){
            CircularProgressIndicator()
        }
    }
    else{
        LazyColumn (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(8.dp)){

            items(state.coinList){coinUi ->
                CoinListItem(
                    coinUi = coinUi,
                    onClick = {}
                )
                HorizontalDivider()
            }
        }
    }
}

@Preview
@Composable
fun PreviewCoinListScreen(){
//    CoinListScreen(
//        state = CoinListState(
//            coinList = (1..100).map {
//                previewCoin.copy(id = it.toString()).toCoinUi()
//            }
//        )
//    )
}