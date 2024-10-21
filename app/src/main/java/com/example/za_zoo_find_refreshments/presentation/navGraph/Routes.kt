package com.example.za_zoo_find_refreshments.presentation.navGraph

sealed class Routes(
    val route: String
) {
    object HomeScreen : Routes(route = "homeScreen")
}