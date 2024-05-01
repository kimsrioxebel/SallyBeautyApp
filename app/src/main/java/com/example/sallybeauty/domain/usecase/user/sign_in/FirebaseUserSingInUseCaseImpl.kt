package com.example.sallybeauty.domain.usecase.user.sign_in

import com.example.sallybeauty.domain.entity.user.FirebaseSignInUserEntity
import com.example.sallybeauty.domain.entity.user.UserInformationEntity
import com.example.sallybeauty.domain.repository.FirebaseRepository
import javax.inject.Inject


class FirebaseUserSingInUseCaseImpl @Inject constructor(
    private val firebaseRepository: FirebaseRepository
): FirebaseUserSingInUseCase {
    override fun invoke(user: FirebaseSignInUserEntity, onSuccess: (UserInformationEntity) -> Unit, onFailure: (String) -> Unit) {
        firebaseRepository.signInWithFirebase(user, onSuccess, onFailure)
    }
}