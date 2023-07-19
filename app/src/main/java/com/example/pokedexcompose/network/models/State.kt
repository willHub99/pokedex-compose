package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class State(
    @SerializedName("name")
    val name: String
)
