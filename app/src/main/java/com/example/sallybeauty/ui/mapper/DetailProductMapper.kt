package com.example.sallybeauty.ui.mapper

import com.example.sallybeauty.domain.entity.product.DetailProductEntity
import com.example.sallybeauty.domain.mapper.ProductBaseMapper
import com.sallyBeauty.ecommerce_compose.ui.uiData.DetailProductUiData
import javax.inject.Inject


class DetailProductEntityToUiMapper @Inject constructor() :
    ProductBaseMapper<DetailProductEntity, DetailProductUiData> {
    override fun map(input: DetailProductEntity): DetailProductUiData {
        return DetailProductUiData(
            productId = input.id,
            title = input.title,
            description = input.description,
            price = input.price,
            imageUrl = input.imageUrl,
            rating = input.rating,
            )
        }
}