package com.example.sallybeauty.domain.usecase.user.sign_up

import com.example.sallybeauty.domain.entity.user.UserInformationEntity
import com.example.sallybeauty.domain.repository.FirebaseRepository
import com.example.sallybeauty.domain.usecase.user.sign_up.FirebaseUserSignUpUseCase
import javax.inject.Inject


class FirebaseUserSignUpUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository,
) : FirebaseUserSignUpUseCase {
    override fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        firebaseRepository.signUpWithFirebase(user, onSuccess, onFailure)
    }
}
