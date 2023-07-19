package com.example.pokedexcompose.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.pokedexcompose.R

val robotoFontFamily = FontFamily(
    Font(R.font.robotoblack),
    Font(R.font.robotobold, FontWeight.Bold),
    Font(R.font.robotolight, weight = FontWeight.Light),
    Font(R.font.robotothin, weight = FontWeight.Thin),
    Font(R.font.robotoitalic, weight = FontWeight.Normal, style = FontStyle.Italic)
)

val Typography2 = Typography(
    bodySmall = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        color = Color.White
    ),
    bodyMedium = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp,
        color = Color.White
    ),
    titleSmall = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        color = Color.White
    ),
    titleMedium = TextStyle(
        fontFamily = robotoFontFamily,
        fontWeight = FontWeight.Light,
        fontSize = 44.sp,
        color = Color.White
    ),
    titleLarge = TextStyle(
        fontFamily = robotoFontFamily,
        fontStyle = FontStyle.Italic,
        fontSize = 64.sp,
        color = Color.White
    )
)
