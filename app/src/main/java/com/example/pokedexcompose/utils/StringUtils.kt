package com.example.pokedexcompose.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

const val REPLACEMENT_STRING_URL = "https://pokeapi.co/api/v2/pokemon"
const val REPLACEMENT_STRING_LIMIT = "limit="
const val REPLACEMENT_STRING_OFFSET = "?offset="
val gson: Gson = Gson()

fun String.getIdFromUrl(): Int {
    return this.replace(REPLACEMENT_STRING_URL, "")
        .replace("/", "")
        .trim()
        .toInt()
}

fun String.getOffsetAndLimit(): Pair<Int, Int> {
    val split = this.replace(REPLACEMENT_STRING_URL, "").split("&")
    val offset = split[0].replace(REPLACEMENT_STRING_OFFSET, "").trim().toInt()
    val limit = split[1].replace(REPLACEMENT_STRING_LIMIT, "").trim().toInt()
    return limit to offset
}

fun String.removeSeparatorString(): String {
    return this.replace("-", " ")
}

fun String.customCapitalize(): String {
    return this.replaceFirstChar {
        it.uppercase()
    }
}

fun <T> T.toJson(): String {
    return gson.toJson(this)
}

fun <T> String.fromJson(): List<T> {
    val typeToken = object : TypeToken<List<T>>() {}.type
    return Gson().fromJson<List<T>>(this, typeToken)
}
