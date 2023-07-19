package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("name")
    val name: String,
    @SerializedName("height")
    val height: Int,
    @SerializedName("weight")
    val weight: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("stats")
    val stats: List<PokemonState>,
    @SerializedName("types")
    val types: List<PokemonType>,
    @SerializedName("sprites")
    val sprite: PokemonTypeImage
)
