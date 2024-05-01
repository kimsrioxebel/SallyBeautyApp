package com.example.sallybeauty.data.mapper

import com.example.sallybeauty.data.dto.Product
import com.example.sallybeauty.domain.entity.product.DetailProductEntity
import com.example.sallybeauty.domain.mapper.ProductBaseMapper
import javax.inject.Inject


class SingleProductEntityMapper @Inject constructor() :
    ProductBaseMapper<Product, DetailProductEntity> {
    override fun map(input: Any): DetailProductEntity {
        return DetailProductEntity(
            id = input.id,
            title = input.title,
            description = input.description,
            price = input.price.toString(),
            imageUrl = input.images,
            rating = input.rating.toString(),
        )
    }
}
