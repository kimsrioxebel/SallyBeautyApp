package com.example.sallybeauty.ui.mapper

import com.example.sallybeauty.domain.entity.cart.UserCartEntity
import com.example.sallybeauty.domain.entity.product.FavoriteProductEntity
import com.example.sallybeauty.domain.mapper.ProductBaseMapper
import com.example.sallybeauty.domain.mapper.ProductListMapper
import com.sallyBeauty.ecommerce_compose.ui.uiData.UserCartUiData
import javax.inject.Inject


class CartEntityToUiMapper @Inject constructor() :
    ProductListMapper<UserCartEntity, UserCartUiData> {
    override fun map(input: List<UserCartEntity>): List<UserCartUiData> {
        return input.map {
            UserCartUiData(
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

class CartUiToEntityMapper @Inject constructor() :
    ProductBaseMapper<UserCartUiData, UserCartEntity> {
    override fun map(input: UserCartUiData): UserCartEntity {
        return UserCartEntity(
            userId = input.userId,
            productId = input.productId,
            price = input.price,
            quantity = input.quantity,
            title = input.title,
            image = input.imageUrl,
        )
    }
}
class CartEntityToFavoriteEntityMapper @Inject constructor() :
    ProductBaseMapper<UserCartEntity, FavoriteProductEntity> {
    override fun map(input: UserCartEntity): FavoriteProductEntity {
        return FavoriteProductEntity(
            userId = input.userId,
            productId = input.productId,
            price = input.price,
            quantity = input.quantity,
            title = input.title,
            image = input.image,
        )
    }
    }
