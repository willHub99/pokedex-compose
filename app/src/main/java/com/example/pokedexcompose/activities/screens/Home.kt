package com.example.pokedexcompose.activities.screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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

@Composable
fun Home(
    navController: NavController
) {
    val viewModel: HomeViewModel = HomeViewModel(LocalContext.current)
    val pageState: PageState by viewModel.pageState.collectAsState()
    val listPokemonState: PokemonListState by viewModel.listPokemonState.collectAsState()



    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val listState = rememberLazyListState()
        val getNextPage by remember() {
            derivedStateOf {
                listState.firstVisibleItemIndex > (pageState.actualLimit - 5)
            }
        }
        var position by rememberSaveable {
            mutableIntStateOf(0)
        }
        val scope = rememberCoroutineScope()
        CustomSearchBar()
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxWidth()
        ) {
            listPokemonState.items.let { list ->
//                scope.launch {
//                    listState.animateScrollToItem(position)
//                }
                items(list) { pokemon ->
                    CardPokemonItem(
                        pokemon = pokemon,
                        navigation = {navController.navigate(Screen.Details.withArgs(pokemon.id.toString()))}
                    )
                }
                item {
                    AnimatedVisibility(visible = getNextPage) {
                        if (pageState.hasNewPage) {
                            viewModel.getMainPage()
                        }
                        CustomLottieAnimation(file = R.raw.pokemon_load)
                    }
                }
            }
        }
    }
}
