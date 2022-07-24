package com.artsman.hasqvarnamovies.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleListItem(message: String){
    Box(Modifier.padding(12.dp, 24.dp)) {
        Text(style = MaterialTheme.typography.h6, text = message)
    }
}


@Preview
@Composable
fun SimpleListItemPreview(){
    SimpleListItem(message = "Simple List Item")
}