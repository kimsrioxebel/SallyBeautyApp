package com.example.sallybeauty.di.mappers

import com.example.sallybeauty.domain.entity.user.UserInformationEntity
import com.example.sallybeauty.domain.entity.cart.UserCartEntity
import com.example.sallybeauty.ui.mapper.CartEntityToFavoriteEntityMapper
import com.example.sallybeauty.ui.mapper.CartEntityToUiMapper
import com.example.sallybeauty.ui.mapper.CartUiToEntityMapper
import com.example.sallybeauty.ui.mapper.DetailProductEntityToUiMapper
import com.example.sallybeauty.ui.mapper.FavoriteEntityToUiMapper
import com.example.sallybeauty.ui.mapper.FavoriteUiToEntityMapper
import com.example.sallybeauty.ui.mapper.ProductEntityToUiMapper
import com.example.sallybeauty.ui.mapper.UserInfoEntityToUiDataMapper
import com.example.sallybeauty.ui.mapper.UserInfoUiDataToEntityMapper
import com.example.sallybeauty.domain.entity.product.DetailProductEntity
import com.example.sallybeauty.domain.entity.product.FavoriteProductEntity
import com.example.sallybeauty.domain.entity.product.ProductEntity
import com.example.sallybeauty.domain.mapper.ProductBaseMapper
import com.example.sallybeauty.domain.mapper.ProductListMapper
import com.google.android.datatransport.runtime.dagger.Binds
import com.google.android.datatransport.runtime.dagger.Module
import com.sallyBeauty.ecommerce_compose.ui.uiData.DetailProductUiData
import com.sallyBeauty.ecommerce_compose.ui.uiData.FavoriteUiData
import com.sallyBeauty.ecommerce_compose.ui.uiData.ProductUiData
import com.sallyBeauty.ecommerce_compose.ui.uiData.UserCartUiData
import com.sallyBeauty.ecommerce_compose.ui.uiData.UserInformationUiData
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class UiMapperModule {
    @Binds
    @ViewModelScoped
    abstract fun bindHomeProductUiMapper(productUiDataMapper: ProductEntityToUiMapper): ProductListMapper<ProductEntity, ProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindDetailProductUiMapper(productUiDataMapper: DetailProductEntityToUiMapper): ProductBaseMapper<DetailProductEntity, DetailProductUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindCartUiMapper(cartUiDataMapper: CartEntityToUiMapper): ProductListMapper<UserCartEntity, UserCartUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartUiMapper(singleCartUiDataMapper: CartUiToEntityMapper): ProductBaseMapper<UserCartUiData, UserCartEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoEntityToUiDataMapper(userInformationUiDataMapper: UserInfoEntityToUiDataMapper): ProductBaseMapper<UserInformationEntity, UserInformationUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindUserInfoUiDataToEntityMapper(userInformationEntityMapperToUi: UserInfoUiDataToEntityMapper): ProductBaseMapper<UserInformationUiData, UserInformationEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindFavoriteItemUiMapper(favoriteEntityToUiMapper: FavoriteEntityToUiMapper): ProductListMapper<FavoriteProductEntity, FavoriteUiData>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleFavoriteItemUiMapper(favoriteUiToEntityMapper: FavoriteUiToEntityMapper): ProductBaseMapper<FavoriteUiData, FavoriteProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindSingleCartToFavoriteEntityMapper(cartEntityToFavoriteEntityMapper: CartEntityToFavoriteEntityMapper): ProductBaseMapper<UserCartEntity, FavoriteProductEntity>
}
