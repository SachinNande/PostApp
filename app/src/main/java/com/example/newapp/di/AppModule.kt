package com.example.newapp.di

import com.example.newapp.data.api.ApiService
import com.example.newapp.data.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesPostRepository(apiService: ApiService) : PostRepository{
        return PostRepository(apiService)
    }
}