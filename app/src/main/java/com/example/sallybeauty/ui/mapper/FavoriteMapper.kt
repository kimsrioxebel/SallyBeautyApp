package com.example.sallybeauty.ui.mapper

import com.example.sallybeauty.domain.entity.product.FavoriteProductEntity
import com.example.sallybeauty.domain.mapper.ProductBaseMapper
import com.example.sallybeauty.domain.mapper.ProductListMapper
import com.sallyBeauty.ecommerce_compose.ui.uiData.FavoriteUiData
import javax.inject.Inject


class FavoriteEntityToUiMapper @Inject constructor() :
    ProductListMapper<FavoriteProductEntity, FavoriteUiData> {
    override fun map(input: List<FavoriteProductEntity>): List<FavoriteUiData> {
        return input.map {
            FavoriteUiData(
                userId = it.userId,
                productId = it.productId,
                price = it.price,
                quantity = it.quantity,
                title = it.title,
                imageUrl = it.image,
            )
        }
    }
}

class FavoriteUiToEntityMapper @Inject constructor() :
    ProductBaseMapper<FavoriteUiData, FavoriteProductEntity> {
    override fun map(input: FavoriteUiData): FavoriteProductEntity {
        return FavoriteProductEntity(
            userId = input.userId,
            productId = input.productId,
            price = input.price,
            quantity = input.quantity,
            title = input.title,
            image = input.imageUrl,
            )
        }
}