package com.example.pokedexcompose.utils

import com.example.pokedexcompose.R

val imageByType = arrayOf(
    "normal" to R.drawable.normal,
    "fighting" to R.drawable.fighting,
    "flying" to R.drawable.flying,
    "poison" to R.drawable.poison,
    "ground" to R.drawable.ground,
    "rock" to R.drawable.rock,
    "bug" to R.drawable.bug,
    "ghost" to R.drawable.ghost,
    "steel" to R.drawable.steel,
    "fire" to R.drawable.fire,
    "water" to R.drawable.water,
    "grass" to R.drawable.grass,
    "electric" to R.drawable.electrict,
    "psychic" to R.drawable.physic,
    "ice" to R.drawable.ice,
    "dragon" to R.drawable.dragon,
    "dark" to R.drawable.dark,
    "fairy" to R.drawable.fairy,
    "unknown" to R.drawable.normal,
    "shadow" to R.drawable.ghost
)

fun String.getImageByType(): Int {
    return imageByType.firstOrNull {
        this == it.first
    }?.second ?: R.drawable.normal
}
