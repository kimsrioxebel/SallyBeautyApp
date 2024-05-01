package com.example.sallybeauty.data.source.remote

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.data.dto.Product
import com.example.sallybeauty.data.dto.Products
import kotlinx.coroutines.flow.Flow


interface RemoteDataSource {
    fun getProductsListFromApi(): Flow<NetworkResponseState<Products>>

    fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<Product>>

    fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<Products>>

    fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>>

    fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<Products>>
}
