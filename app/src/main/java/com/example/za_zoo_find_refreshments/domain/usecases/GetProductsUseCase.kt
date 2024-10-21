package com.example.za_zoo_find_refreshments.domain.usecases

import arrow.core.Either
import com.example.za_zoo_find_refreshments.domain.model.ErrorResponse
import com.example.za_zoo_find_refreshments.domain.model.Products
import com.example.za_zoo_find_refreshments.domain.repository.GetProductsRepository

/*
there is no use of useCase can be done with repository injection,
but still implementing as stated in assignment doc use clean architecture
*/
data class GetProductsUseCase(
    val getProducts: GetProducts
)

class GetProducts(
    private val repository: GetProductsRepository
) {
    suspend operator fun invoke(query: String, location: String): Either<ErrorResponse, Products> {
        return repository.getProducts(query, location)
    }
}