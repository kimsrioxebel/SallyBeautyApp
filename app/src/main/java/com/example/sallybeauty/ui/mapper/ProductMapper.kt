package com.example.sallybeauty.ui.mapper

import com.example.sallybeauty.domain.entity.product.ProductEntity
import com.example.sallybeauty.domain.mapper.ProductListMapper
import com.sallyBeauty.ecommerce_compose.ui.uiData.ProductUiData
import javax.inject.Inject


class ProductEntityToUiMapper @Inject constructor() :
    ProductListMapper<ProductEntity, ProductUiData> {
    override fun map(input: List<ProductEntity>): List<ProductUiData> {
        return input.map {
            ProductUiData(
                id = it.id,
                title = it.title,
                description = it.description,
                price = it.price,
                imageUrl = it.imageUrl,
                rating = it.rating,
            )
            }
        }
}