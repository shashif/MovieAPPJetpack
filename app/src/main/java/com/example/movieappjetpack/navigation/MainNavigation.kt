package com.example.movieappjetpack.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieappjetpack.screens.details.DetailsScreen
import com.example.movieappjetpack.screens.home.HomeScreen

@Composable
fun MainNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigationScreens.HomeScreen.name
    ) {


        composable(NavigationScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }


        composable(NavigationScreens.DetailsScreen.name + "/{detailsInformation}",
            arguments = listOf(navArgument(name = "detailsInformation") {
                type = NavType.StringType
            }

            )
        ) { backStackEntry ->
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("detailsInformation")
            )

        }


    }
}