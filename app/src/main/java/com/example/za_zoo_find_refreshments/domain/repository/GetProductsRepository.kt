package com.example.za_zoo_find_refreshments.domain.repository

import arrow.core.Either
import com.example.za_zoo_find_refreshments.domain.model.ErrorResponse
import com.example.za_zoo_find_refreshments.domain.model.Products

interface GetProductsRepository {
    suspend fun getProducts(query: String, location: String):  Either<ErrorResponse, Products>
}