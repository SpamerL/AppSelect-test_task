package com.kryak.appselect_test_task.data.remote.api

import com.kryak.appselect_test_task.BuildConfig
import com.kryak.appselect_test_task.data.dto.ReviewListDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NYTApi {

    @GET("reviews/all.json")
    suspend fun getReviews(
        @Query("offset") offset: Int,
        @Query("api-key") apiKey: String = BuildConfig.API_KEY
    ): Response<ReviewListDTO>
}
