package com.example.sallybeauty.domain.usecase.user.write_user

import com.example.sallybeauty.domain.entity.user.UserInformationEntity
import com.example.sallybeauty.domain.repository.FirebaseRepository
import javax.inject.Inject


class WriteFirebaseUserInfosCaseImpl @Inject constructor(
    private val repository: FirebaseRepository,
) : WriteFirebaseUserInfosUseCase {
    override fun invoke(
        user: UserInformationEntity,
        onSuccess: () -> Unit,
        onFailure: (String) -> Unit,
    ) {
        repository.writeNewUserToFirebaseDatabase(user, onSuccess, onFailure)
    }
}
