package com.example.za_zoo_find_refreshments.presentation.navGraph

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.za_zoo_find_refreshments.presentation.features.home.HomeScreen
import com.example.za_zoo_find_refreshments.presentation.viewmodels.HomeViewModel


@Composable
fun NavGraph(
) {
    val navController = rememberNavController()
    val homeViewModel: HomeViewModel = hiltViewModel()
    val state by homeViewModel.state.collectAsStateWithLifecycle()

    NavHost(
        navController = navController,
        startDestination = Routes.HomeScreen.route
    ) {
        composable(route = Routes.HomeScreen.route) {
            HomeScreen(viewModel = homeViewModel, state = state)
        }
    }
}