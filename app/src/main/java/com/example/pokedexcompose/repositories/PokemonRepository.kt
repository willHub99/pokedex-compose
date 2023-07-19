package com.example.pokedexcompose.repositories


import com.example.pokedexcompose.model.PokemonModel
import com.example.pokedexcompose.network.models.PokeApiResponse
import com.example.pokedexcompose.network.retrofit.PokeApiRetrofitService
import com.example.pokedexcompose.utils.convertToPokemonModel
import retrofit2.Response

class PokemonRepository() {

    private val apiService: PokeApiRetrofitService = PokeApiRetrofitService()

    suspend fun getPokemonById(id: Int): PokemonModel {
        val response = apiService.getPokemonById(id)
        var pokemonResponse: PokemonModel = PokemonModel()
        if (response.isSuccessful) {
            response.body()?.let {pokemon ->
                pokemonResponse = pokemon.convertToPokemonModel()
            }
        }
        return pokemonResponse
    }

    suspend fun getPageWithOffsetAndLimit(offset: Int, limit: Int): Response<PokeApiResponse> {
        return apiService.getPageWithOffsetAndLimit(offset, limit)
    }

}
