package com.example.pokedexcompose.utils

import com.example.pokedexcompose.database.PokemonEntity
import com.example.pokedexcompose.model.PokemonModel
import com.example.pokedexcompose.network.models.Pokemon

fun Pokemon.convertToPokemonModel(): PokemonModel {
    return PokemonModel(
        name = this.name,
        height = this.height,
        weight = this.weight,
        id = this.id,
        stats = getListStats(this),
        types = getListTypes(this),
        sprite = this.sprite.other.frontDefault.url
    )
}

fun getListTypes(pokemon: Pokemon): ArrayList<String> {
    val types = ArrayList<String>()
    for (type in pokemon.types) {
        types.add(type.type.name)
    }
    return types
}

fun getListStats(pokemon: Pokemon): ArrayList<Pair<String, Int>> {
    val stats = ArrayList<Pair<String, Int>>()
    for (stat in pokemon.stats) {
        stats.add(stat.stat.name to stat.baseStat)
    }
    return stats
}

fun PokemonModel.convertToPokemonEntity(): PokemonEntity {
    return PokemonEntity(
        name = this.name,
        height = this.height,
        weight = this.weight,
        isFavorite = this.isFavorite,
        id = this.id,
        stats = this.stats.toJson(),
        types = this.types.toJson(),
        sprite = sprite ?: ""
    )
}

fun PokemonEntity.convertToPokemonModel(): PokemonModel {
    return PokemonModel(
        name = this.name,
        height = this.height,
        weight = this.weight,
        id = this.id,
        stats = this.stats.fromJson(),
        types = this.types.fromJson(),
        sprite = this.sprite
    )
}
