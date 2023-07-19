package com.example.pokedexcompose.viewmodels

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexcompose.model.PokemonModel
import com.example.pokedexcompose.network.models.PokeApiResponse
import com.example.pokedexcompose.network.models.Pokemon
import com.example.pokedexcompose.network.models.PokemonApiItemResponse
import com.example.pokedexcompose.repositories.PokemonRepository
import com.example.pokedexcompose.state.PageState
import com.example.pokedexcompose.state.PokemonListState
import com.example.pokedexcompose.utils.convertToPokemonEntity
import com.example.pokedexcompose.utils.convertToPokemonModel
import com.example.pokedexcompose.utils.filtered
import com.example.pokedexcompose.utils.getIdFromUrl
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.Response
import java.util.ArrayList
import kotlin.math.ceil

class HomeViewModel(
    context: Context
) : ViewModel() {

    private val repository: PokemonRepository by lazy {
        PokemonRepository()
    }

    private val _pageState = MutableStateFlow(PageState())
    val pageState = _pageState.asStateFlow()

    private val _listPokemonState = MutableStateFlow(PokemonListState())
    val listPokemonState = _listPokemonState.asStateFlow()

    init {
        val scope = CoroutineScope(Dispatchers.IO)
        scope.launch {
            getMainPage()
        }
    }

    fun getMainPage() = viewModelScope.launch(Dispatchers.IO) {
        _pageState.update {
            it.copy(isLoading = true)
        }
        try {
            val response = repository.getPageWithOffsetAndLimit(
                pageState.value.actualOffset,
                pageState.value.actualLimit
            )
            if (response.isSuccessful) {
                _pageState.update {
                    it.copy(
                        page = response.body(),
                        isLoading = false,
                        actualLimit = _pageState.value.actualLimit + 20,
                        actualOffset = _pageState.value.actualLimit,
                    )
                }
                response.body()?.let { response ->
                    getListPokemon(response.results)
                }
            }
        } catch (e: Exception) {
            _pageState.update {
                it.copy(error = e.message ?: "")
            }
        }
    }

    private suspend fun getPokemonById(id: Int): PokemonModel {
        return repository.getPokemonById(id)
    }

    private suspend fun getListPokemon(results: List<PokemonApiItemResponse>) {
        _listPokemonState.update {
            it.copy(isLoading = true)
        }
        try {
            val listPokemonPage = ArrayList<PokemonModel>()
            for (item in results) {
                val pokemon = getPokemonById(item.url.getIdFromUrl())
                pokemon.let { pokemon ->
                    listPokemonPage.add(pokemon)
                }
            }
            _listPokemonState.update {
                it.copy(
                    items = it.items + listPokemonPage,
                    isLoading = false
                )
            }
            _pageState.update {
                it.copy(
                    hasNewPage = listPokemonPage.isNotEmpty()
                )
            }
        } catch (e: Exception) {
            _listPokemonState.update {
                it.copy(error = e.message ?: "")
            }
        }
    }
}
