package com.example.pokedexcompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokedexcompose.model.PokemonModel
import com.example.pokedexcompose.utils.getCardBackgroundColor
import com.example.pokedexcompose.viewmodels.HomeViewModel

@Composable
fun CardPokemonItem(
    pokemon: PokemonModel,
    navigation: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = 8.dp,
                end = 8.dp,
                top = 64.dp,
                bottom = 32.dp
            )
            .clickable {
                navigation()
            }
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            PokemonDetails(pokemon)
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomImage(
                urlImage = pokemon.sprite,
                size = 200,
                offset = 100
            )
        }
    }
}

@Composable
private fun PokemonDetails(
    pokemon: PokemonModel,
) {
    var isFavorite by rememberSaveable {
        mutableStateOf(pokemon.isFavorite)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .size(250.dp),
        colors = CardDefaults.cardColors(
            containerColor = pokemon.types[0].getCardBackgroundColor()
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )
    ) {
        IconButton(
            onClick = {
                isFavorite = !isFavorite
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(
                imageVector = if (isFavorite) Icons.Default.Star else Icons.Default.StarOutline,
                contentDescription = "favorite icon",
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
        DetailsPokemon(pokemon = pokemon)
    }
}
