package com.example.za_zoo_find_refreshments.presentation.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.za_zoo_find_refreshments.domain.usecases.GetProductsUseCase
import com.example.za_zoo_find_refreshments.presentation.viewmodels.events.ProductsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {


    private val _state = MutableStateFlow(ProductsState())
    val state = _state.asStateFlow()

    init {
        //getProducts(query = "Juice", location = "McKinney")
    }

    private fun getProducts(query: String, location: String) {
        viewModelScope.launch {
            _state.update { it.copy(loading = true) }
            getProductsUseCase.getProducts(query = query, location = location).onRight { products ->
                Log.d("check 1", "getProducts loading: ${state.value.loading}")
                delay(3000)
                _state.update {
                    it.copy(
                        products = products,
                        loading = false
                    )
                }
                Log.d("check", "getProducts loading: ${state.value.loading}")
                Log.d("check", "getProducts Name: ${state.value.products?.detailResultsThisPage[0]?.name}")
            }.onLeft {
                Log.d("check", "getProducts Error: ${it.error}")
            }
        }
    }
}