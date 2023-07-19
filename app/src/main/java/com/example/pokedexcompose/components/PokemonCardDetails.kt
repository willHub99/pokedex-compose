package com.example.pokedexcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pokedexcompose.model.PokemonModel
import com.example.pokedexcompose.navigation.Screen
import com.example.pokedexcompose.ui.theme.robotoFontFamily
import com.example.pokedexcompose.utils.customCapitalize
import com.example.pokedexcompose.utils.getCardBackgroundColor

@Composable
fun CardDetail(
    pokemon: PokemonModel,
    navigation: () -> Unit
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = pokemon.types[0].getCardBackgroundColor()
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        shape = RoundedCornerShape(
            topStart = 50.dp,
            topEnd = 50.dp,
            bottomStart = 0.dp,
            bottomEnd = 0.dp
        ),
        modifier = Modifier.fillMaxHeight(0.75f)
    ) {
        IconButton(
            onClick = {
                navigation()
            },
            modifier = Modifier
                .padding(16.dp)
        ) {
            Icon(
                Icons.Filled.ChevronLeft,
                contentDescription = "Button Back to List Pokemon",
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text(
                    text = pokemon.name.customCapitalize(),
                    style = TextStyle(
                        color = Color.White,
                        fontFamily = robotoFontFamily,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Spacer(modifier = Modifier.width(16.dp))
                ListTypesPokemon(types = pokemon.types)
            }
            Text(
                text = "Stats",
                style = TextStyle(
                    color = Color.White,
                    fontFamily = robotoFontFamily,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            PokemonStates(pokemon.stats, pokemon.types[0])
        }
    }
}
