package com.example.sallybeauty.domain.usecase.favorite

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.entity.product.FavoriteProductEntity
import com.example.sallybeauty.domain.repository.LocalRepository
import com.example.sallybeauty.domain.usecase.favorite.FavoriteUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class FavoriteUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : FavoriteUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>> =
        repository.getFavoriteProductsFromDb(userId)

    override suspend fun invoke(item: FavoriteProductEntity) {
        repository.insertFavoriteProductToDb(item)
    }
}
