package com.example.pokedexcompose.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PokemonDao {

    @Query("SELECT * FROM favorites WHERE id = :id limit 1")
    fun findPokemonById(id: Int): PokemonEntity

    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): List<PokemonEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFavoritePokemon(pokemon: PokemonEntity)

    @Delete
    suspend fun removeFavoritePokemon(pokemon: PokemonEntity)
}
