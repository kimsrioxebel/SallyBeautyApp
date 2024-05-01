package com.example.sallybeauty.domain.usecase.user.write_user

import com.example.sallybeauty.domain.entity.user.UserInformationEntity


interface WriteFirebaseUserInfosUseCase {
    operator fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    )
}
