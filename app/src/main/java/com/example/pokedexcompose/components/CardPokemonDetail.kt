package com.example.pokedexcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.pokedexcompose.model.PokemonModel
import com.example.pokedexcompose.navigation.Screen

@Composable
fun CardPokemonDetail(
    pokemon: PokemonModel,
    navigation: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            CardDetail(
                pokemon = pokemon,
                navigation = navigation
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomImage(
                urlImage = pokemon.sprite,
                size = 300,
                offset = 30
            )
        }
    }
}
