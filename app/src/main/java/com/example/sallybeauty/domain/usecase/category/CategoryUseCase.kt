package com.example.sallybeauty.domain.usecase.category

import com.example.sallybeauty.common.NetworkResponseState
import kotlinx.coroutines.flow.Flow


interface CategoryUseCase {
    operator fun invoke(): Flow<NetworkResponseState<List<String>>>
}
