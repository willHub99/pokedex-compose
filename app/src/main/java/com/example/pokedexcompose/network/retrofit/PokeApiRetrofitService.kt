package com.example.pokedexcompose.network.retrofit

import com.example.pokedexcompose.constants.ApiConstants
import com.example.pokedexcompose.network.models.PokeApiResponse
import com.example.pokedexcompose.network.models.Pokemon
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokeApiRetrofitService {

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(ApiConstants.POKE_BASE_URL)
        .build()

    private val service: PokeApiService = retrofit.create(PokeApiService::class.java)

    suspend fun getPage(): Response<PokeApiResponse> {
        return service.getPage()
    }

    suspend fun getPokemonById(id: Int): Response<Pokemon> {
        return service.getPokemonById(id)
    }

    suspend fun getPageWithOffsetAndLimit(offset: Int, limit: Int): Response<PokeApiResponse> {
        return service.getPageWithOffsetAndLimit(offset, limit)
    }
}
