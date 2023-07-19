package com.example.pokedexcompose.viewmodels

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedexcompose.model.PokemonModel
import com.example.pokedexcompose.repositories.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PokemonDetailsViewModel(
    context: Context
) : ViewModel() {

    private val repository: PokemonRepository by lazy {
        PokemonRepository()
    }
    private val _pokemonDetail: MutableLiveData<PokemonModel> = MutableLiveData()
    var pokemonDetail: MutableLiveData<PokemonModel> = _pokemonDetail

    fun getPokemonDetails(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        val response = repository.getPokemonById(id)
        response.let {
            pokemonDetail.postValue(it)
        }

    }
}
