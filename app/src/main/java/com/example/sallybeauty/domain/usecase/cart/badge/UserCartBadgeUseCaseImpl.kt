package com.example.sallybeauty.domain.usecase.cart.badge

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class UserCartBadgeUseCaseImpl @Inject constructor(
    private val repository: LocalRepository,
) : UserCartBadgeUseCase {
    override suspend fun invoke(userId: String): Flow<NetworkResponseState<Int>> {
        return repository.getBadgeCountFromDb(userId)
    }
}
