package com.example.pokedexcompose.state

import com.example.pokedexcompose.network.models.PokeApiResponse

data class PageState(
    val page: PokeApiResponse? = null,
    val isLoading: Boolean = false,
    val error: String = "",
)
