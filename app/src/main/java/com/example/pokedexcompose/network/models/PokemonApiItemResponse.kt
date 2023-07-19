package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class PokemonApiItemResponse(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
