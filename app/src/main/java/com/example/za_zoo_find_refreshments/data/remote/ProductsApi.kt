package com.example.za_zoo_find_refreshments.data.remote

import com.example.za_zoo_find_refreshments.domain.model.Products
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductsApi {
    @GET("search")
    suspend fun getProducts(
        @Query("query") query: String,
        @Query("location") location: String,
        @Query("page") page: Int = 12
    ): Products
}