package com.example.sallybeauty.domain.usecase.product

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.entity.product.ProductEntity
import com.example.sallybeauty.domain.repository.RemoteRepository
import com.example.sallybeauty.domain.usecase.product.SearchProductUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchProductUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : SearchProductUseCase {
    override fun invoke(query: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return repository.getProductsListBySearchFromApi(query)
    }
}
