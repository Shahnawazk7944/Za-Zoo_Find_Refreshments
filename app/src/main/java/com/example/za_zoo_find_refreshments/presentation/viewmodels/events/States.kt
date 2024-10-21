package com.example.za_zoo_find_refreshments.presentation.viewmodels.events

import com.example.za_zoo_find_refreshments.domain.model.Products

data class ProductsState(
    val products: Products? = null,
    val loading: Boolean = false,
    val error: String? = null
)
