package com.kryak.appselect_test_task.di

import com.kryak.appselect_test_task.data.pagination.ReviewsPagingSource
import com.kryak.appselect_test_task.data.remote.api.NYTApi
import com.kryak.appselect_test_task.data.repository.RepositoryImpl
import com.kryak.appselect_test_task.domain.ReviewRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesRepository(api: NYTApi): ReviewRepository =
        RepositoryImpl(api)

    @Provides
    @Singleton
    fun providesPagingSource(api: NYTApi): ReviewsPagingSource =
        ReviewsPagingSource(api)
}