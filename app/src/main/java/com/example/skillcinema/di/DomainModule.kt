package com.example.skillcinema.di

import com.example.skillcinema.domain.repository.Repository
import com.example.skillcinema.domain.useCase.GetListCollectionsUseCase
import com.example.skillcinema.domain.useCase.GetListFilmsFilterUseCase
import com.example.skillcinema.domain.useCase.GetListFilmsTypeUseCase
import com.example.skillcinema.domain.useCase.GetListPremieresUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetListPremieresUseCase(repository: Repository): GetListPremieresUseCase {
        return GetListPremieresUseCase(repository)
    }

    @Provides
    fun provideGetListCollectionsUseCase(repository: Repository): GetListCollectionsUseCase {
        return GetListCollectionsUseCase(repository)
    }

    @Provides
    fun provideGetListFilmsFilterUseCase(repository: Repository): GetListFilmsFilterUseCase {
        return GetListFilmsFilterUseCase(repository)
    }

    @Provides
    fun provideGetListFilmsTypeUseCase(repository: Repository): GetListFilmsTypeUseCase {
        return GetListFilmsTypeUseCase(repository)
    }
}