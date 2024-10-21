package com.example.za_zoo_find_refreshments.domain.model

import com.google.gson.annotations.SerializedName

 data class Products(
    @SerializedName("SR") val sr: String,
    @SerializedName("TimeTaken") val timeTaken: Double,
    @SerializedName("SearchQuery") val searchQuery: String,
    @SerializedName("SearchLocation") val searchLocation: String,
    @SerializedName("PageRequested") val pageRequested: Int,
    @SerializedName("TotalResults_AllPages") val totalResultsAllPages: Int,
    @SerializedName("DefaultResultsPerPage") val defaultResultsPerPage: Int,
    @SerializedName("NumResultsThisPage") val numResultsThisPage: Int,
    @SerializedName("DetailResultsThisPage") val detailResultsThisPage: List<DetailResult>
)

data class DetailResult(
    val ranking: Int?,
    val isAD: Boolean,
    val name: String,
    val businessURL: String,
    val categories: List<Category>,
    val priceRange: String,
    val rating: Double,
    val reviewCount: Int,
    val neighborhoods: List<String>,
    val phone: String,
    val website: String,
    val scrollablePhotos: List<ScrollablePhoto>,
    @SerializedName("longitudelatitude")
    val longitudeLatitude: LongitudeLatitude?
)

data class Category(
    val title: String,
    val url: String
)

data class ScrollablePhoto(
    val src: String,
    @SerializedName("srcset")
    val srcSet: String
)

data class LongitudeLatitude(
    val latitude: Double,
    val longitude: Double
)