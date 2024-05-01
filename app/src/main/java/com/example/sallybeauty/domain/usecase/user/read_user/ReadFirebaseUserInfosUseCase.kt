package com.example.sallybeauty.domain.usecase.user.read_user

import com.example.sallybeauty.domain.entity.user.UserInformationEntity


interface ReadFirebaseUserInfosUseCase {
    operator fun invoke(
        userId: String,
        onSuccess: (UserInformationEntity) -> Unit,
        onFailure: (String) -> Unit,
    )
}
