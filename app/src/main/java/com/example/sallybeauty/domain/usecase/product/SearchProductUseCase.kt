package com.example.sallybeauty.domain.usecase.product

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.entity.product.ProductEntity
import kotlinx.coroutines.flow.Flow


interface SearchProductUseCase {
    operator fun invoke(query: String): Flow<NetworkResponseState<List<ProductEntity>>>
}
