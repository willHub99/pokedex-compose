package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class PokeApiResponse(
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: String,
    @SerializedName("results")
    val results: List<PokemonApiItemResponse>
)
