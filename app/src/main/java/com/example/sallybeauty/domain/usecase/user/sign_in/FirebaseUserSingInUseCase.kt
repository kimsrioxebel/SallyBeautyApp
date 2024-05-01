package com.example.sallybeauty.domain.usecase.user.sign_in

import com.example.sallybeauty.domain.entity.user.UserInformationEntity
import com.example.sallybeauty.domain.entity.user.FirebaseSignInUserEntity


interface FirebaseUserSingInUseCase {
    operator fun invoke(
        user: FirebaseSignInUserEntity,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit
    )
}