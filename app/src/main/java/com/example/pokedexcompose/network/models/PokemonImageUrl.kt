package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class PokemonImageUrl(
    @SerializedName("front_default")
    val url: String
)
