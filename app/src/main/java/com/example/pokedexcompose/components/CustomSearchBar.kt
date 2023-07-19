package com.example.pokedexcompose.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.pokedexcompose.network.models.PokeApiResponse
import com.example.pokedexcompose.viewmodels.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomSearchBar(
) {
    var text by rememberSaveable {
        mutableStateOf("")
    }
    var active by rememberSaveable {
        mutableStateOf(false)
    }

    val rememberSearchItems by rememberSaveable {
        mutableStateOf(ArrayList<String>())
    }

    SearchBar(
        query = text,
        onQueryChange = { query ->
            text = query
        },
        onSearch = {

            rememberSearchItems.add(it)
            text = ""
            active = false
        },
        active = active,
        onActiveChange = {
            active = it
        },
        placeholder = {
            Text(text = "Enter with the pokemon name")
        },
        leadingIcon = {
            IconButton(
                onClick = {
                    rememberSearchItems.add(text)
                    text = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search icon"
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
        trailingIcon = {
            IconButton(
                onClick = {
                    text = ""
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "Search icon"
                )
            }
        }
    ) {
        LazyColumn {
            items(rememberSearchItems) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clickable {
                            text = ""
                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Icon history search pokemon"
                    )
                    Text(text = it)
                }
            }
        }
    }
}
