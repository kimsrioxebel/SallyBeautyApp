package com.example.sallybeauty.domain.usecase.product

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.entity.product.DetailProductEntity
import com.example.sallybeauty.domain.repository.RemoteRepository
import com.example.sallybeauty.domain.usecase.product.GetSingleProductUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetSingleProductUseCaseImpl @Inject constructor(
    private val repository: RemoteRepository,
) : GetSingleProductUseCase {
    override fun invoke(id: Int): Flow<NetworkResponseState<DetailProductEntity>> =
        repository.getSingleProductByIdFromApi(id)
}
