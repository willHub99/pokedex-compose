package com.example.pokedexcompose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.pokedexcompose.activities.screens.Home
import com.example.pokedexcompose.activities.screens.PokemonDetail

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.screen) {
        composable(route = Screen.Home.screen) {
            Home(navController)
        }
        composable(
            route = Screen.Details.screen + "/{id}",
            arguments = listOf(
                navArgument("id") {
                    type = NavType.StringType
                }
            )
        ) { entry ->
            entry.arguments?.getString("id")?.let {
                PokemonDetail(pokemonId = it.toInt(), navController)
            }
        }
    }
}
