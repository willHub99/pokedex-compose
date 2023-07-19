package com.example.pokedexcompose.activities.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.pokedexcompose.components.CardPokemonDetail
import com.example.pokedexcompose.model.PokemonModel
import com.example.pokedexcompose.navigation.Screen
import com.example.pokedexcompose.viewmodels.PokemonDetailsViewModel

@Composable
fun PokemonDetail(
    pokemonId: Int,
    navController: NavController
) {
    val viewModel: PokemonDetailsViewModel = PokemonDetailsViewModel(LocalContext.current)
    viewModel.getPokemonDetails(pokemonId)
    val pokemonDetail: PokemonModel? by viewModel.pokemonDetail.observeAsState()

    pokemonDetail?.let {
        CardPokemonDetail(
            pokemon = it,
            navigation = {navController.navigate(Screen.Home.screen)}
        )
    }
}
