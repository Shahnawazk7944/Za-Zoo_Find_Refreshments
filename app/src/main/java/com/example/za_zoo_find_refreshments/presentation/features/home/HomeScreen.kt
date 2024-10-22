package com.example.za_zoo_find_refreshments.presentation.features.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.za_zoo_find_refreshments.presentation.features.home.components.ChangeLocationDialog
import com.example.za_zoo_find_refreshments.presentation.features.home.components.ChangeLocationSection
import com.example.za_zoo_find_refreshments.presentation.features.home.components.EmptyScreen
import com.example.za_zoo_find_refreshments.presentation.features.home.components.FilterProductSection
import com.example.za_zoo_find_refreshments.presentation.features.home.components.HomeScreenProductsHeading
import com.example.za_zoo_find_refreshments.presentation.features.home.components.HomeScreenTopBarHeading
import com.example.za_zoo_find_refreshments.presentation.features.home.components.NavigationBar
import com.example.za_zoo_find_refreshments.presentation.features.home.components.RefreshmentsPager
import com.example.za_zoo_find_refreshments.presentation.features.home.components.ZaZooShimmerEffect
import com.example.za_zoo_find_refreshments.presentation.viewmodels.HomeViewModel
import com.example.za_zoo_find_refreshments.presentation.viewmodels.events.HomeEvent
import com.example.za_zoo_find_refreshments.presentation.viewmodels.events.ProductsState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier, viewModel: HomeViewModel, state: ProductsState) {
    val pagerState = rememberPagerState(pageCount = { state.products.size })
    if (!state.loading) {
        if (state.error == null) {
            Scaffold(containerColor = MaterialTheme.colorScheme.background, bottomBar = {
                NavigationBar(state = state)
            }) { innerPadding ->
                var changeLocationDialog by remember { mutableStateOf(false) }
                Column(
                    modifier = modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .verticalScroll(rememberScrollState())
                ) {
                    HomeScreenTopBarHeading()
                    Spacer(modifier = Modifier.size(30.dp))
                    FilterProductSection(
                        onProductChange = { product ->
                        viewModel.onEvent(HomeEvent.FilterProducts(product))},
                        state = state)
                    Spacer(modifier = Modifier.size(30.dp))
                    HomeScreenProductsHeading()
                    RefreshmentsPager(pagerState = pagerState, state = state, addToCart = {
                        viewModel.onEvent(HomeEvent.AddToCart(it))
                    }, addImageToCart = {
                        viewModel.onEvent(HomeEvent.AddProductImageToCart(it))
                    })
                    ChangeLocationSection(
                        openChangeLocationDialog = { changeLocationDialog = it },
                        state = state
                    )

                    if (changeLocationDialog) {
                        ChangeLocationDialog(onLocationChange = { newLocation ->
                            viewModel.onEvent(HomeEvent.ChangeLocation(newLocation))
                            changeLocationDialog = false
                        }, onCancel = {
                            changeLocationDialog = false
                        })
                    }
                }
            }
        } else {
            EmptyScreen(error = state.error)
        }
    } else {
        ZaZooShimmerEffect()
    }
}


@Composable
@Preview
@Preview(name = "Night Mode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun HomeScreenPreview() {
    HomeScreen(
        modifier = TODO(),
        viewModel = TODO(),
        state = TODO()
    )
}