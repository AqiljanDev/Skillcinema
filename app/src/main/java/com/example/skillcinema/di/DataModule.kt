package com.example.skillcinema.di

import com.example.skillcinema.data.RepositoryImpl
import com.example.skillcinema.data.api.HomepageApi
import com.example.skillcinema.domain.repository.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideRepositoryImpl(): Repository {
        return RepositoryImpl()
    }

}