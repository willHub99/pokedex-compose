package com.example.pokedexcompose.network.models

import com.google.gson.annotations.SerializedName

data class Type(
    @SerializedName("name")
    val name: String
)
