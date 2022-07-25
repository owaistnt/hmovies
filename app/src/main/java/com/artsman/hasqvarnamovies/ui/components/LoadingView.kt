package com.artsman.hasqvarnamovies.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import com.artsman.hasqvarnamovies.R

@Composable
fun LoadingView(modifier: Modifier= Modifier, message: String){
    Box(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly) {
            Image(colorFilter = ColorFilter.tint(MaterialTheme.colors.primaryVariant), painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "", modifier = Modifier.fillMaxSize(fraction = 0.6f))
            CircularProgressIndicator()
            Text(text = message)
        }

    }
}