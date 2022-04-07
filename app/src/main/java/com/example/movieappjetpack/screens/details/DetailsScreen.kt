package com.example.movieappjetpack.screens.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieappjetpack.MovieRow
import com.example.movieappjetpack.model.DataClass
import com.example.movieappjetpack.model.getMovies

@Composable
fun DetailsScreen(
    navController: NavController, dataID: String?
) {

    val newDataList = getMovies().filter { fetchData ->
        fetchData.id == dataID
    }
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Gray, elevation = 5.dp
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))
                Text(text = "Movies")
            }
        }
    }) {

        //content here
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth()
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                MovieRow(movie = newDataList[0])

                //Text(text = newDataList[0].title, style = MaterialTheme.typography.h5)
                Spacer(modifier = Modifier.height(8.dp))
                Divider()

                Text(text = "Movie Image")

                HorizontalScrollableImage(newDataList)


                Spacer(modifier = Modifier.height(23.dp))

                Button(onClick = {
                    navController.popBackStack()
                }) {


                    Text(text = "Go Back")
                }
            }
        }


    }


}

@Composable
private fun HorizontalScrollableImage(newDataList: List<DataClass>) {
    LazyRow {
        items(newDataList[0].images) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = image),
                    contentDescription = "Movie poster"
                )
            }
        }
    }
}