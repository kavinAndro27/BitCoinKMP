package com.example.cryptotrackerkmp.crypto.presentation.coin_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ArrowUpward
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cryptotrackerkmp.theme.greenBackground
import com.example.cryptotrackerkmp.util.DisplayableNumber
import org.jetbrains.compose.ui.tooling.preview.Preview


@Composable
fun PriceChange(
    change: DisplayableNumber,
    modifier: Modifier = Modifier
){

    val contentColor = if (change.value <0 ) MaterialTheme.colorScheme.onErrorContainer else
        Color.Green

    val backGroundColor = if (change.value <0 ) MaterialTheme.colorScheme.errorContainer else
        greenBackground

    val arrow = if (change.value < 0) {
        Icons.Filled.ArrowDownward
    } else {
        Icons.Filled.ArrowUpward
    }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(100f))
            .background(backGroundColor)
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = arrow,
            contentDescription = null,
            tint = contentColor
        )

        Text(
            text = change.formatted,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            color = contentColor
        )

    }

}


@Preview
@Composable
fun PreviewPriceChange(){

    PriceChange(
        change = DisplayableNumber(
            value = 2.33,
            formatted = "2.33 %"
        )
    )
}