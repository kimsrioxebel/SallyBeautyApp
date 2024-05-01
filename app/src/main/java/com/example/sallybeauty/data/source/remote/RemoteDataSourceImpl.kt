package com.example.sallybeauty.data.source.remote

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.data.api.ApiService
import com.example.sallybeauty.data.dto.Product
import com.example.sallybeauty.data.dto.Products
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

//import kotlinx.coroutines.flow.internal.NopCollector.emit


class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
) : RemoteDataSource {
    override fun getProductsListFromApi(): Flow<NetworkResponseState<Products>> {
        return flow {
            emit(NetworkResponseState.Loading)
            try {
                val response = apiService.getProductsListFromApi()
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception) {
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getSingleProductByIdFromApi(productId: Int): Flow<NetworkResponseState<Product>> {
        return flow {
            try {
                emit(NetworkResponseState.Loading)
                val response = apiService.getSingleProductByIdFromApi(productId)
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception) {
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getProductsListBySearchFromApi(query: String): Flow<NetworkResponseState<Products>> {
        return flow {
            emit(NetworkResponseState.Loading)
            try {
                val response = apiService.getProductsListBySearchFromApi(query)
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception) {
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getAllCategoriesListFromApi(): Flow<NetworkResponseState<List<String>>> {
        return flow {
            emit(NetworkResponseState.Loading)
            try {
                val response = apiService.getAllCategoriesListFromApi()
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception) {
                emit(NetworkResponseState.Error(e))
            }
        }
    }

    override fun getProductsListByCategoryNameFromApi(categoryName: String): Flow<NetworkResponseState<Products>> {
        return flow {
            try {
                emit(NetworkResponseState.Loading)
                val response = apiService.getProductsListByCategoryNameFromApi(categoryName)
                emit(NetworkResponseState.Success(response))
            } catch (e: Exception) {
                emit(NetworkResponseState.Error(e))
            }
        }
    }
}
