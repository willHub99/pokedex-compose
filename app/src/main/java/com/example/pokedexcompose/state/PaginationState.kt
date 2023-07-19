package com.example.pokedexcompose.state

data class PaginationState(
    val limit: Int = 20,
    val actualOffset: Int = 0,
    val hasNewPage: Boolean = true
)
