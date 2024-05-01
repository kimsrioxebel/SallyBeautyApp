package com.example.sallybeauty.domain.usecase.cart.badge

import com.example.sallybeauty.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow


interface UserCartBadgeUseCase {
    suspend operator fun invoke(userId: String): Flow<NetworkResponseState<Int>>
}