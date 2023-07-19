package com.example.pokedexcompose.state

import com.example.pokedexcompose.network.models.PokeApiResponse

data class PageState(
    val page: PokeApiResponse? = null,
    val isLoading: Boolean = false,
    val error: String = "",
    val actualLimit: Int = 20,
    val actualOffset: Int = 0,
    val hasNewPage: Boolean = true
)
