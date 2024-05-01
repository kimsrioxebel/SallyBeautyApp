package com.example.sallybeauty.di.mappers

import com.example.sallybeauty.data.dto.Product
import com.example.sallybeauty.data.mapper.ProductEntityMapper
import com.example.sallybeauty.data.mapper.SingleProductEntityMapper
import com.example.sallybeauty.domain.entity.product.DetailProductEntity
import com.example.sallybeauty.domain.entity.product.ProductEntity
import com.example.sallybeauty.domain.mapper.ProductBaseMapper
import com.example.sallybeauty.domain.mapper.ProductListMapper
import com.google.android.datatransport.runtime.dagger.Binds
import com.google.android.datatransport.runtime.dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindAllProductsEntityMapper(productEntityMapper: ProductEntityMapper): ProductListMapper<Product, ProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleProductEntityMapper(singleProductEntityMapper: SingleProductEntityMapper): ProductBaseMapper<Product, DetailProductEntity>
}
