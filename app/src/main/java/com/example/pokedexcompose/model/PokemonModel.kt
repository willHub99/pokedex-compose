package com.example.pokedexcompose.model

data class PokemonModel(
    val name: String = "",
    val height: Int = 0,
    val weight: Int = 0,
    var isFavorite: Boolean = false,
    val id: Int = 0,
    val stats: List<Pair<String, Int>> = emptyList(),
    val types: List<String> = emptyList(),
    val sprite: String? = null
)
