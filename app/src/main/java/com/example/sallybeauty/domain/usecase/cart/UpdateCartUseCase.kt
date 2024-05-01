package com.example.sallybeauty.domain.usecase.cart

import com.example.sallybeauty.domain.entity.cart.UserCartEntity

// ktlint-disable package-name


interface UpdateCartUseCase {
    suspend operator fun invoke(userCartEntity: UserCartEntity)
}
