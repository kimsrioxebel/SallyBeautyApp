package com.example.sallybeauty.domain.repository

import com.example.sallybeauty.domain.entity.cart.UserCartEntity
import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.entity.product.FavoriteProductEntity
import kotlinx.coroutines.flow.Flow


interface LocalRepository {

    suspend fun getCartsByUserIdFromDb(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>>

    suspend fun insertUserCartToDb(userCartEntity: UserCartEntity)

    suspend fun deleteUserCart(userCartEntity: UserCartEntity)

    suspend fun updateUserCart(userCartEntity: UserCartEntity)

    suspend fun getFavoriteProductsFromDb(userId: String): Flow<NetworkResponseState<List<FavoriteProductEntity>>>

    suspend fun insertFavoriteProductToDb(favoriteProductEntity: FavoriteProductEntity)

    suspend fun deleteFavoriteProduct(favoriteProductEntity: FavoriteProductEntity)

    suspend fun getBadgeCountFromDb(userId: String): Flow<NetworkResponseState<Int>>
}
