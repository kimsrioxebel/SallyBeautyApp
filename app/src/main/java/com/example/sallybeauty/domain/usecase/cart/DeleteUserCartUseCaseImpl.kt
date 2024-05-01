package com.example.sallybeauty.domain.usecase.cart

import com.example.sallybeauty.domain.entity.cart.UserCartEntity
import com.example.sallybeauty.domain.repository.LocalRepository
import com.example.sallybeauty.domain.usecase.cart.DeleteUserCartUseCase
import javax.inject.Inject


class DeleteUserCartUseCaseImpl @Inject constructor(private val repository: LocalRepository) :
    DeleteUserCartUseCase {
    override suspend fun invoke(userCartEntity: UserCartEntity) {
        repository.deleteUserCart(userCartEntity)
    }
}
