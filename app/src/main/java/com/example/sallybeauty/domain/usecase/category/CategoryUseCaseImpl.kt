package com.example.sallybeauty.domain.usecase.category

import com.example.sallybeauty.common.NetworkResponseState
import com.example.sallybeauty.domain.repository.RemoteRepository
import com.example.sallybeauty.domain.usecase.category.CategoryUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class CategoryUseCaseImpl @Inject constructor(private val repository: RemoteRepository) :
    CategoryUseCase {
    override fun invoke(): Flow<NetworkResponseState<List<String>>> {
        return repository.getAllCategoriesListFromApi()
    }
}
