package com.example.sallybeauty.domain.entity.product

data class ProductEntity(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val imageUrl: String,
    val rating: Double,
)
