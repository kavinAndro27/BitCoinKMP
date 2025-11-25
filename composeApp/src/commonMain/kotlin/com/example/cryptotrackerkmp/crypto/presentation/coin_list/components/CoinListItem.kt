package com.example.cryptotrackerkmp.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotrackerkmp.crypto.domain.Coin
import com.example.cryptotrackerkmp.crypto.presentation.models.CoinUi
import com.example.cryptotrackerkmp.crypto.presentation.models.toCoinUi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun CoinListItem(
    coinUi: CoinUi,
    onClick:()->Unit,
    modifier: Modifier = Modifier
){

    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Row (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
        , verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){

        Icon(
            painter = painterResource(coinUi.iconRes),
            contentDescription = coinUi.name,
            tint = MaterialTheme.colorScheme.primary,
            modifier = Modifier.size(85.dp)
        )

        Column(modifier = Modifier.weight(1f)) {

            Text(
                text = coinUi.symbol,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor
            )

            Text(
                text = coinUi.name,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = contentColor
            )
        }

        Column(horizontalAlignment = Alignment.End) {

            Text(
                text = "$ ${coinUi.price.formatted}",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = contentColor
            )

            Spacer(modifier = Modifier.height(8.dp))

            PriceChange(
                change = coinUi.changePercent24Hr
            )
        }
    }


}


@Preview( )
@Composable
fun PreviewCoinUi(){
    CoinListItem(
        coinUi = previewCoin.toCoinUi() ,
        onClick={

        },
        modifier = Modifier.background(
            color = MaterialTheme.colorScheme.primaryContainer
        )

    )
}

internal val previewCoin = Coin(
    id = "bitcoin",
    rank = "1",
    name = "Bitcoin",
    symbol = "BTC",
    marketCap = 1_200_000_000_000.0,
    marketCapCurrency = "USD",
    price = 42_500.78,
    priceCurrency = "USD",
    changePercent24Hr = 3.57
)


