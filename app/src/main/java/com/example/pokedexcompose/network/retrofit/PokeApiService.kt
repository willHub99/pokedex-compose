package com.example.pokedexcompose.network.retrofit

import com.example.pokedexcompose.network.models.PokeApiResponse
import com.example.pokedexcompose.network.models.Pokemon
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokeApiService {
    @GET("pokemon")
    suspend fun getPage(): Response<PokeApiResponse>

    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Response<Pokemon>

    @GET("pokemon")
    suspend fun getPageWithOffsetAndLimit(@Query("offset") offset: Int, @Query("limit") limit: Int): Response<PokeApiResponse>
}
