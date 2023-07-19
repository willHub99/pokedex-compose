package com.example.pokedexcompose.activities.screens



import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.pokedexcompose.R
import com.example.pokedexcompose.components.CardPokemonItem
import com.example.pokedexcompose.components.CustomSearchBar
import com.example.pokedexcompose.navigation.Screen
import com.example.pokedexcompose.state.PageState
import com.example.pokedexcompose.state.PokemonListState
import com.example.pokedexcompose.viewmodels.HomeViewModel
import com.example.pokedexcompose.components.CustomLottieAnimation
import com.example.pokedexcompose.state.PaginationState

@Composable
fun Home(
    navController: NavController
) {
    val viewModel: HomeViewModel = HomeViewModel(LocalContext.current)
    val pageState: PageState by viewModel.pageState.collectAsState()
    val listPokemonState: PokemonListState by viewModel.listPokemonState.collectAsState()
    val paginationState: PaginationState by viewModel.paginationState.collectAsState()

    val listState = rememberLazyListState()
    val getNextPage by remember {
        derivedStateOf {
            val allowGetNewPokemonCall = if (paginationState.actualOffset != 0) paginationState.actualOffset else 20
            listState.firstVisibleItemIndex > (allowGetNewPokemonCall - 3)
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CustomSearchBar()
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxWidth()
        ) {
            listPokemonState.items.let { list ->
                items(list) { pokemon ->
                    CardPokemonItem(
                        pokemon = pokemon,
                        navigation = { navController.navigate(Screen.Details.withArgs(pokemon.id.toString())) }
                    )
                }
                item {
                    AnimatedVisibility(visible = getNextPage) {
                        CustomLottieAnimation(file = R.raw.pokemon_load)
                        LaunchedEffect(key1 = getNextPage ) {
                            viewModel.updatePaginationState()
                        }
                    }
                }
            }
        }
    }
}
