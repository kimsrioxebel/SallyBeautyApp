package com.example.sallybeauty.domain.usecase.user.sign_up

import com.example.sallybeauty.domain.entity.user.UserInformationEntity


interface FirebaseUserSignUpUseCase {
    operator fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )
}
