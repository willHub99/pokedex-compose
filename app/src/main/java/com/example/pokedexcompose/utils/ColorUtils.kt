package com.example.pokedexcompose.utils

import androidx.compose.ui.graphics.Color
import com.example.pokedexcompose.ui.theme.BugColor
import com.example.pokedexcompose.ui.theme.BugDarkColor
import com.example.pokedexcompose.ui.theme.DarkColor
import com.example.pokedexcompose.ui.theme.DarkDarkColor
import com.example.pokedexcompose.ui.theme.DefaultColor
import com.example.pokedexcompose.ui.theme.DefaultDarkColor
import com.example.pokedexcompose.ui.theme.DragonColor
import com.example.pokedexcompose.ui.theme.DragonDarkColor
import com.example.pokedexcompose.ui.theme.ElectricColor
import com.example.pokedexcompose.ui.theme.ElectricDarkColor
import com.example.pokedexcompose.ui.theme.FairyColor
import com.example.pokedexcompose.ui.theme.FairyDarkColor
import com.example.pokedexcompose.ui.theme.FightingColor
import com.example.pokedexcompose.ui.theme.FightingDarkColor
import com.example.pokedexcompose.ui.theme.FireColor
import com.example.pokedexcompose.ui.theme.FireDarkColor
import com.example.pokedexcompose.ui.theme.FlyingColor
import com.example.pokedexcompose.ui.theme.FlyingDarkColor
import com.example.pokedexcompose.ui.theme.GhostColor
import com.example.pokedexcompose.ui.theme.GhostDarkColor
import com.example.pokedexcompose.ui.theme.GrassColor
import com.example.pokedexcompose.ui.theme.GrassDarkColor
import com.example.pokedexcompose.ui.theme.GroundColor
import com.example.pokedexcompose.ui.theme.GroundDarkColor
import com.example.pokedexcompose.ui.theme.IceColor
import com.example.pokedexcompose.ui.theme.IceDarkColor
import com.example.pokedexcompose.ui.theme.NormalColor
import com.example.pokedexcompose.ui.theme.NormalDarkColor
import com.example.pokedexcompose.ui.theme.PhysicColor
import com.example.pokedexcompose.ui.theme.PhysicDarkColor
import com.example.pokedexcompose.ui.theme.PoisonColor
import com.example.pokedexcompose.ui.theme.PoisonDarkColor
import com.example.pokedexcompose.ui.theme.RockColor
import com.example.pokedexcompose.ui.theme.RockDarkColor
import com.example.pokedexcompose.ui.theme.SteelColor
import com.example.pokedexcompose.ui.theme.SteelDarkColor
import com.example.pokedexcompose.ui.theme.WaterColor
import com.example.pokedexcompose.ui.theme.WaterDarkColor

val colorByType = arrayOf(
    "normal" to NormalColor,
    "fighting" to FightingColor,
    "flying" to FlyingColor,
    "poison" to PoisonColor,
    "ground" to GroundColor,
    "rock" to RockColor,
    "bug" to BugColor,
    "ghost" to GhostColor,
    "steel" to SteelColor,
    "fire" to FireColor,
    "water" to WaterColor,
    "grass" to GrassColor,
    "electric" to ElectricColor,
    "psychic" to PhysicColor,
    "ice" to IceColor,
    "dragon" to DragonColor,
    "dark" to DarkColor,
    "fairy" to FairyColor,
    "unknown" to DefaultColor,
    "shadow" to GhostColor
)

fun String.getCardBackgroundColor(): Color {
    return colorByType.firstOrNull {
        this == it.first
    }?.second ?: DefaultColor
}

val colorLinearProgressByType = arrayOf(
    "normal" to NormalDarkColor,
    "fighting" to FightingDarkColor,
    "flying" to FlyingDarkColor,
    "poison" to PoisonDarkColor,
    "ground" to GroundDarkColor,
    "rock" to RockDarkColor,
    "bug" to BugDarkColor,
    "ghost" to GhostDarkColor,
    "steel" to SteelDarkColor,
    "fire" to FireDarkColor,
    "water" to WaterDarkColor,
    "grass" to GrassDarkColor,
    "electric" to ElectricDarkColor,
    "psychic" to PhysicDarkColor,
    "ice" to IceDarkColor,
    "dragon" to DragonDarkColor,
    "dark" to DarkDarkColor,
    "fairy" to FairyDarkColor,
    "unknown" to DefaultDarkColor,
    "shadow" to GhostDarkColor
)

fun String.getProgressIndicatorBackgroundColor(): Color {
    return colorLinearProgressByType.firstOrNull {
        this == it.first
    }?.second ?: DefaultColor
}
