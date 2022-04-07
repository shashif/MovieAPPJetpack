package com.example.movieappjetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.movieappjetpack.navigation.MainNavigation
import com.example.movieappjetpack.ui.theme.MovieAPPJetpackTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApp {
                MainNavigation()
            }

        }
    }
}


@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAPPJetpackTheme {

        content()
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainNavigation()
    }
}

