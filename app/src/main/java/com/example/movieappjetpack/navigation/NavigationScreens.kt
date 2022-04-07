package com.example.movieappjetpack.navigation

enum class NavigationScreens {
    HomeScreen,
    DetailsScreen;

    companion object{
        fun fromRoute(route:String?):NavigationScreens=when(route?.substringBefore("/")){
            HomeScreen.name->HomeScreen
            DetailsScreen.name->DetailsScreen
            null->HomeScreen
            else-> throw java.lang.IllegalArgumentException("Route $route is not recognize ")
        }

    }
}