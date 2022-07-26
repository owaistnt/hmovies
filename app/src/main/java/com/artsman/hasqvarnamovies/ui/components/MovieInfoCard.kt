package com.artsman.hasqvarnamovies.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MovieInfoCard(title: String, overview: String, rating: Long, adult: String, modifier: Modifier = Modifier){
    Card(backgroundColor = MaterialTheme.colors.onPrimary.copy(alpha = 0.6f), modifier =  modifier.padding(4.dp, 4.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            if(title.length < 15){
                MovieTitle(title = title,)
            }else
                MovieTitleCompact(title = title)
            Text(text = overview, modifier = Modifier.padding(6.dp, 6.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                RatingItem(rating = rating)
                Divider(
                    color = Color.LightGray,
                    modifier = Modifier
                        .height(50.dp)
                        .width(1.dp)
                )
                AdultRatingItem(adult = adult)
            }


        }
    }
}

@Preview
@Composable
fun MovieInfoCardPreview(){
    MovieInfoCard(title = "Movie Name", "Some Bla bla bla about Movie", 2224, "Yes")
}

@Composable
fun RatingItem(rating: Long){
    Column(Modifier.padding(8.dp, 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = Icons.Default.Favorite, contentDescription = "", tint = Color.Red)
        Spacer(modifier = Modifier.height(6.dp))
        Text(text = rating.toString(), style = MaterialTheme.typography.body2)
    }
}

@Composable
fun AdultRatingItem(adult: String){
    Column(Modifier.padding(8.dp, 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "", tint = Color.Yellow)
        Text(text = "Adult", style = MaterialTheme.typography.body2)
        Text(text = adult, style = MaterialTheme.typography.body2)
    }
}

@Preview
@Composable
fun RatingItemPreview(){
    RatingItem(rating = 1229)
}