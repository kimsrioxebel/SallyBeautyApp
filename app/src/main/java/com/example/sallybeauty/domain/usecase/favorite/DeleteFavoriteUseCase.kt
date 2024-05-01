package com.example.sallybeauty.domain.usecase.favorite

import com.example.sallybeauty.domain.entity.product.FavoriteProductEntity

interface DeleteFavoriteUseCase {
    suspend operator fun invoke(favoriteProductEntity: FavoriteProductEntity)
}