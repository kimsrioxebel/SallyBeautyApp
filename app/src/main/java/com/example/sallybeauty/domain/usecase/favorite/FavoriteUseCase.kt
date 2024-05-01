package com.example.sallybeauty.domain.usecase.favorite

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.entity.product.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow


interface FavoriteUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> // getFavoriteProductsFromLocal

    suspend operator fun invoke(item: FavoriteProductEntity) // insertFavoriteItemToDb
}
