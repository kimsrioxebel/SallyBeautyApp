package com.example.sallybeauty.di.repository

import com.example.sallybeauty.data.repository.FirebaseRepositoryImpl
import com.example.sallybeauty.domain.repository.FirebaseRepository
import com.example.sallybeauty.domain.repository.LocalRepository
import com.example.sallybeauty.domain.repository.RemoteRepository
import com.google.android.datatransport.runtime.dagger.Binds
import com.google.android.datatransport.runtime.dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule<RemoteRepositoryImpl, LocalRepositoryImpl> {

    @Binds
    @ViewModelScoped
    abstract fun bindRemoteRepository(
        repository: RemoteRepositoryImpl,
    ): RemoteRepository

    @Binds
    @ViewModelScoped
    abstract fun bindLocalRepository(
        repository: LocalRepositoryImpl,
    ): LocalRepository

    @Binds
    @ViewModelScoped
    abstract fun bindFirebaseRepository(
        repository: FirebaseRepositoryImpl,
    ): FirebaseRepository
}
