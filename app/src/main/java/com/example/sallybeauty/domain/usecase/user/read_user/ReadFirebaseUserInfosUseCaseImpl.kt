package com.example.sallybeauty.domain.usecase.user.read_user

import com.example.sallybeauty.domain.entity.user.UserInformationEntity
import com.example.sallybeauty.domain.repository.FirebaseRepository
import com.example.sallybeauty.domain.usecase.user.read_user.ReadFirebaseUserInfosUseCase
import javax.inject.Inject


class ReadFirebaseUserInfosUseCaseImpl @Inject constructor(
    private val repository: FirebaseRepository
): ReadFirebaseUserInfosUseCase {
    override fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    ) {
        repository.readUserFromFirebaseDatabase(userId, onSuccess, onFailure)
    }
}