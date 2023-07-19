package com.example.pokedexcompose.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.ui.graphics.vector.ImageVector

val iconIfIsFavoritePokemon = arrayOf(
    true to Icons.Default.Star,
    false to Icons.Default.StarOutline
)

fun Boolean.getIcon(): ImageVector {
    return iconIfIsFavoritePokemon.first {
        this == it.first
    }.second
}
