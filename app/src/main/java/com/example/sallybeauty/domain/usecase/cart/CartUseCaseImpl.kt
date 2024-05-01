package com.example.sallybeauty.domain.usecase.cart

import com.example.sallybeauty.domain.entity.cart.UserCartEntity
import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.repository.LocalRepository
import com.example.sallybeauty.domain.usecase.cart.CartUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CartUseCaseImpl @Inject constructor(private val repository: LocalRepository) : CartUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<List<UserCartEntity>>> = repository.getCartsByUserIdFromDb(userId)
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.insertUserCartToDb(userCartEntity)
    }
}
