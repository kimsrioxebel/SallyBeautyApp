package com.example.sallybeauty.domain.usecase.cart

import com.example.sallybeauty.domain.entity.cart.UserCartEntity
import com.example.sallybeauty.domain.repository.LocalRepository
import com.example.sallybeauty.domain.usecase.cart.UpdateCartUseCase
import javax.inject.Inject

// ktlint-disable package-name



class UpdateCartUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : UpdateCartUseCase {
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.updateUserCart(userCartEntity)
    }
}
