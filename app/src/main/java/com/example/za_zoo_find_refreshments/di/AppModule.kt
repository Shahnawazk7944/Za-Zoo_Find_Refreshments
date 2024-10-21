package com.example.za_zoo_find_refreshments.di

import com.example.za_zoo_find_refreshments.data.remote.ProductsApi
import com.example.za_zoo_find_refreshments.data.repository.GetProductsRepositoryImpl
import com.example.za_zoo_find_refreshments.domain.repository.GetProductsRepository
import com.example.za_zoo_find_refreshments.domain.usecases.GetProducts
import com.example.za_zoo_find_refreshments.domain.usecases.GetProductsUseCase
import com.example.za_zoo_find_refreshments.util.Constants.API_HOST
import com.example.za_zoo_find_refreshments.util.Constants.API_KEY
import com.example.za_zoo_find_refreshments.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val request = chain.request().newBuilder()
                    .addHeader("x-rapidapi-key",  API_KEY)
                    .addHeader("x-rapidapi-host", API_HOST)
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideProductsApi(retrofit: Retrofit): ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }


    @Provides
    @Singleton
    fun provideGetProductsRepository(
        api: ProductsApi,
    ): GetProductsRepository = GetProductsRepositoryImpl(api)

    @Provides
    @Singleton
    fun provideGetProductsUseCases(
        getProductsRepository: GetProductsRepository,
    ): GetProductsUseCase {
        return GetProductsUseCase(
            getProducts = GetProducts(getProductsRepository)
        )
    }
}