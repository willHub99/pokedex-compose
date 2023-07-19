package com.example.pokedexcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokedexcompose.ui.theme.robotoFontFamily
import com.example.pokedexcompose.utils.customCapitalize
import com.example.pokedexcompose.utils.getProgressIndicatorBackgroundColor
import com.example.pokedexcompose.utils.removeSeparatorString

@Composable
fun PokemonStates(stats: List<Pair<String, Int>>, typePokemon: String) {
    LazyColumn() {
        items(stats) {
            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = it.first.removeSeparatorString().customCapitalize(),
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = robotoFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                LinearProgressIndicator(
                    progress = (it.second / 100.0).toFloat(),
                    color = typePokemon.getProgressIndicatorBackgroundColor(),
                    trackColor = Color.White,
                    strokeCap = StrokeCap.Round,
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .weight(1f)
                        .height(20.dp)
                        .padding(8.dp)
                )
                Text(
                    text = it.second.toString(),
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = robotoFontFamily,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }
        }
    }
}
