package com.example.za_zoo_find_refreshments.data.repository

import android.util.Log
import arrow.core.Either
import com.example.za_zoo_find_refreshments.data.remote.ProductsApi
import com.example.za_zoo_find_refreshments.domain.model.ErrorResponse
import com.example.za_zoo_find_refreshments.domain.model.Products
import com.example.za_zoo_find_refreshments.domain.repository.GetProductsRepository
import javax.inject.Inject

class GetProductsRepositoryImpl @Inject constructor(
    private val api: ProductsApi
) : GetProductsRepository {
    override suspend fun getProducts(
        query: String, location: String
    ): Either<ErrorResponse, Products> {
        return try {
            return Either.Right(api.getProducts(query, location))
        } catch (e: Exception) {
            return Either.Left(ErrorResponse(e.message ?: "Unknown error"))
        }
    }
}