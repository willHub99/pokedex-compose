package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class OtherTypeImage(
    @SerializedName("home")
    val frontDefault: PokemonImageUrl
)
