package com.example.pokedexcompose.navigation

sealed class Screen(val screen: String) {
    object Splash : Screen("splash")
    object Home : Screen("main_screen")
    object Details : Screen("details")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(screen)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
