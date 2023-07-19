package com.example.pokedexcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokedexcompose.utils.getImageByType

@Composable
fun ListTypesPokemon(
    types: List<String>
) {
    LazyRow() {
        items(types) {
            val painter = it.getImageByType()
            Image(
                painter = painterResource(id = painter),
                contentDescription = "Image type pokemon",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(32.dp)
            )
        }
    }
}
