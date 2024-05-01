package com.example.sallybeauty.data.mapper

import com.example.sallybeauty.data.dto.Product
import com.example.sallybeauty.domain.entity.product.ProductEntity
import com.example.sallybeauty.domain.mapper.ProductListMapper
import javax.inject.Inject


class ProductEntityMapper @Inject constructor() :
    ProductListMapper<Product, ProductEntity> {
    override fun map(input: Any): List<ProductEntity> {
        return input.map {
            ProductEntity(
                id = it.id,
                title = it.title,
                description = it.description,
                price = it.price.toString(),
                imageUrl = it.images[0],
                rating = it.rating,
            )
        }
    }
}
