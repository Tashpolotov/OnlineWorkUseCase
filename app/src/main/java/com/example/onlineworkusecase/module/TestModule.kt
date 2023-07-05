package com.example.onlineworkusecase.module

import com.example.onlineworkusecase.data.repository.BankRepositoryMock
import com.example.onlineworkusecase.domain.repository.BankRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class TestModule {

    @Provides
    fun getRepository() : BankRepository{
        return BankRepositoryMock()
    }

}