package com.artsman.hasqvarnamovies.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.layout.onPlaced
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.artsman.hasqvarnamovies.presentation.movies_list.Link

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun MoviePoster(modifier: Modifier= Modifier, poster_url: Link){
    AsyncImage(model = ImageRequest.Builder(LocalContext.current)
        .data(poster_url)
        .build(),
        contentDescription = "Movie Poster",
        contentScale = ContentScale.FillBounds,
        modifier = Modifier.fillMaxWidth()
    )
}