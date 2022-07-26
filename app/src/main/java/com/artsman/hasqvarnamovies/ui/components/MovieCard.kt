package com.artsman.hasqvarnamovies.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.artsman.hasqvarnamovies.presentation.movies_list.Id
import com.artsman.hasqvarnamovies.presentation.movies_list.Link

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieCard(id: Id, title : String, poster_url: Link, onClick: (Long)->Unit){

    Card(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp), onClick = { onClick.invoke(id)}) {
        Box(
            Modifier
                .fillMaxWidth()
                .height(500.dp)) {
            MoviePoster(poster_url = poster_url)
            MovieTitleWithScrim(title= title, modifier = Modifier.align(Alignment.BottomCenter))
            //MovieTitle(title = title, modifier = Modifier.align(Alignment.BottomCenter))
        }
    }


}