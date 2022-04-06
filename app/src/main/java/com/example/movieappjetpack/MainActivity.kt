package com.example.movieappjetpack

import android.content.ContentValues.TAG
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movieappjetpack.ui.theme.MovieAPPJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApp {
                MainContent()
            }

        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAPPJetpackTheme {

        Scaffold(topBar = {
            TopAppBar(
                backgroundColor = Color.Gray,
                elevation = 5.dp
            ) {
                Text(text = "Movies")
            }
        }) {
            content()
        }
    }
}

@Composable
fun MainContent(
    movieList: List<String> = listOf(
        "avatar",
        "RObocop",
        "Happry porter",
        "Life",
    )
) {

    Column(modifier = Modifier.padding(20.dp)) {
        LazyColumn {
            items(items = movieList) {
                MovieRow(movie = it){
                    movie->
                    Log.d("TAG","$movie")
                }
            }
        }
    }


}




@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent()
    }
}