package com.example.pokedexcompose.repositories

import android.content.Context
import com.example.pokedexcompose.database.PokemonEntity
import com.example.pokedexcompose.database.PokemonRoomDatabase

class DatabaseRepository(
    context: Context
) {
    private val database by lazy {
        PokemonRoomDatabase.getInstance(context).pokemonDao()
    }

    suspend fun addFavoritePokemon(pokemon: PokemonEntity) {
        database.addFavoritePokemon(pokemon)
    }

    fun getPokemonById(id: Int): PokemonEntity {
        return database.findPokemonById(id = id)
    }

    fun getAllFavoritePokemon(): List<PokemonEntity> {
        return database.getAllFavorites()
    }

    suspend fun removeFavoritePokemon(pokemon: PokemonEntity) {
        database.removeFavoritePokemon(pokemon = pokemon)
    }
}