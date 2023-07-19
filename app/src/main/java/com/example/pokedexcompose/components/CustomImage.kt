package com.example.pokedexcompose.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.pokedexcompose.constants.IMAGE_POKEMON_DEFAULT

@Composable
fun CustomImage(
    urlImage: String?,
    size: Int,
    offset: Int
) {
    val url = urlImage ?: IMAGE_POKEMON_DEFAULT

    Image(
        painter = rememberAsyncImagePainter(
            model = url
        ),
        contentDescription = "pokemon Image",
        modifier = Modifier
            .size(size.dp)
            .offset(y = (-offset).dp)
    )
}
