package com.example.za_zoo_find_refreshments.presentation.features.home

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
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
import com.example.za_zoo_find_refreshments.presentation.features.home.components.FilterProductSection
import com.example.za_zoo_find_refreshments.presentation.features.home.components.HomeScreenProductsHeading
import com.example.za_zoo_find_refreshments.presentation.features.home.components.HomeScreenTopBarHeading
import com.example.za_zoo_find_refreshments.presentation.features.home.components.NavigationBar
import com.example.za_zoo_find_refreshments.presentation.features.home.components.RefreshmentsPager
import com.example.za_zoo_find_refreshments.presentation.features.home.components.ZaZooShimmerEffect

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(pageCount = { 3 })
    if (true) {
        Scaffold(containerColor = MaterialTheme.colorScheme.background, bottomBar = {
            NavigationBar()
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
                FilterProductSection { product -> }
                Spacer(modifier = Modifier.size(30.dp))
                HomeScreenProductsHeading()
                RefreshmentsPager(pagerState = pagerState, addToCart = {})
                ChangeLocationSection(openChangeLocationDialog = { changeLocationDialog = it })

                if (changeLocationDialog) {
                    ChangeLocationDialog(onLocationChange = { newLocation ->
                        Log.d("check", newLocation)
                        println(newLocation)
                        changeLocationDialog = false
                    }, onCancel = {
                        changeLocationDialog = false
                    })
                }
            }
        }
    } else {
        ZaZooShimmerEffect()
    }
}


@Composable
@Preview
@Preview(name = "Night Mode", uiMode = UI_MODE_NIGHT_YES, showBackground = true)
fun HomeScreenPreview() {
    HomeScreen()
}