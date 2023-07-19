package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class PokemonTypeImage(
    @SerializedName("other")
    val other: OtherTypeImage
)
