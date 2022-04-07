package com.example.movieappjetpack.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.movieappjetpack.MovieRow
import com.example.movieappjetpack.model.DataClass
import com.example.movieappjetpack.model.getMovies
import com.example.movieappjetpack.navigation.NavigationScreens

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Gray, elevation = 5.dp
        ) {
            Text(text = "Movies")
        }
    }) {
        MainContent(navController = navController)
    }
}


@Composable
fun MainContent(
    navController: NavController, movieList: List<DataClass> = getMovies()
) {

    Column(modifier = Modifier.padding(20.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it) { movie1 ->
//                    Log.d("TAG","$movie")
                    navController.navigate(route = NavigationScreens.DetailsScreen.name + "/$movie1")
                }
            }
        }
    }


}