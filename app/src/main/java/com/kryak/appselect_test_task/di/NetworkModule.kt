package com.kryak.appselect_test_task.di

import android.content.Context
import com.kryak.appselect_test_task.data.remote.api.NYTApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/"

    @Provides
    @Singleton
    fun providesOkHttpClient(@ApplicationContext context: Context): OkHttpClient =
        OkHttpClient.Builder().build()

    @Provides
    @Singleton
    fun providesRetrofitBuilder(okHttpClient: OkHttpClient): Retrofit.Builder =
        Retrofit.Builder()
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())

    @Provides
    @Singleton
    fun providesApi(retrofit: Retrofit.Builder): NYTApi =
        retrofit.baseUrl(BASE_URL).build().create(NYTApi::class.java)
}
