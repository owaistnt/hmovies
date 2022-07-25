package com.artsman.hasqvarnamovies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.LinearGradientShader
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.artsman.hasqvarnamovies.R

@Composable
fun MovieTitleWithScrim(title: String, modifier: Modifier= Modifier){
    Box(modifier = modifier
        .fillMaxWidth()
        .fillMaxHeight(0.2f)
        .background(
            Brush.verticalGradient(colors = listOf(Color.Transparent, Color.White.copy(alpha = 0.5f), Color.White.copy(alpha = 0.7f))),
        )){
        if(title.length < 15){
            MovieTitle(title = title, modifier = Modifier.align(Alignment.CenterStart))
        }else{
            MovieTitleCompact(title = title, modifier = Modifier.align(Alignment.CenterStart))
        }
    }
}
@Composable
@Preview
fun MovieTitleScrimPreview(){
    MovieTitleWithScrim("Hangover")
}