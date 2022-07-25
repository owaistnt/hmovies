package com.artsman.hasqvarnamovies.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MovieTitle(modifier: Modifier= Modifier, title: String){
    Text(modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp), text = title, style = MaterialTheme.typography.h3.copy(color = MaterialTheme.colors.onPrimary))
}

@Composable
fun MovieTitleCompact(modifier: Modifier= Modifier, title: String){
    Text(modifier = modifier.padding(horizontal = 8.dp, vertical = 4.dp), text = title, style = MaterialTheme.typography.h5.copy(color = MaterialTheme.colors.onPrimary))
}