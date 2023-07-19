package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class PokemonType(
    @SerializedName("type")
    val type: Type
)
