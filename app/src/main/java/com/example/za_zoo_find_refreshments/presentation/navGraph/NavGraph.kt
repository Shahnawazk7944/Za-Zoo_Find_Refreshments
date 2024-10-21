package com.example.za_zoo_find_refreshments.presentation.navGraph

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.za_zoo_find_refreshments.presentation.features.HomeScreen
import com.example.za_zoo_find_refreshments.presentation.viewmodels.HomeViewModel


@Composable
fun NavGraph(
) {
    val navController = rememberNavController()
    val homeViewModel: HomeViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.route
    ) {
        composable(route = Routes.HomeScreen.route) {
            HomeScreen()
        }
    }
}