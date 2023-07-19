package com.example.pokedexcompose.state

import com.example.pokedexcompose.model.PokemonModel

data class PokemonListState(
    val items: List<PokemonModel> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
