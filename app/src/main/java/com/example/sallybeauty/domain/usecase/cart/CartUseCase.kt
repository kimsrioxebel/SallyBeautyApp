package com.example.sallybeauty.domain.usecase.cart

import com.example.sallybeauty.domain.entity.cart.UserCartEntity
import com.example.sallybeauty.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow

interface CartUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> // getCartsByUserIdFromLocal

    suspend operator fun invoke(userCartEntity: UserCartEntity) // insertCartToDb
}
