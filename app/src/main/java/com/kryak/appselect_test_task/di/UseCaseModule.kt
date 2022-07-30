package com.kryak.appselect_test_task.di

import com.kryak.appselect_test_task.domain.ReviewListUseCase
import com.kryak.appselect_test_task.domain.ReviewRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule {

    @Provides
    @ViewModelScoped
    fun providesUseCase(repository: ReviewRepository): ReviewListUseCase =
        ReviewListUseCase(repository)
}
