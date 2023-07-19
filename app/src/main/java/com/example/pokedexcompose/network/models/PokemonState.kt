package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class PokemonState(
    @SerializedName("base_stat")
    val baseStat: Int,
    @SerializedName("stat")
    val stat: State
)
