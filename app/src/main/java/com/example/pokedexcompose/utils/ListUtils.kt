package com.example.pokedexcompose.utils

import com.example.pokedexcompose.network.models.PokemonApiItemResponse

fun List<PokemonApiItemResponse>.filtered(query: String): List<PokemonApiItemResponse> {
    return this.filter { item ->
        item.name.contains(query)
    }
}

