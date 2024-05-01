package com.example.sallybeauty.domain.usecase.product

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.entity.product.DetailProductEntity
import kotlinx.coroutines.flow.Flow


interface GetSingleProductUseCase {
    operator fun invoke(id: Int): Flow<NetworkResponseState<DetailProductEntity>>
}
