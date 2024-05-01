package com.example.sallybeauty.domain.usecase.product

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.entity.product.ProductEntity
import com.example.sallybeauty.domain.repository.RemoteRepository
import com.example.sallybeauty.domain.usecase.product.GetAllProductsUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetAllProductsUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : GetAllProductsUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<ProductEntity>>> = repository.getProductsListFromApi()

    override fun invoke(categoryName: String): Flow<NetworkResponseState<List<ProductEntity>>> {
        return repository.getProductsListByCategoryNameFromApi(categoryName)
    }
}
