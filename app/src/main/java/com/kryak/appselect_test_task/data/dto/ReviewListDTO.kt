package com.kryak.appselect_test_task.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ReviewListDTO(
    @Json(name = "status")
    val status: String,
    @Json(name = "copyright")
    val copyright: String,
    @Json(name = "has_more")
    val hasMore: Boolean,
    @Json(name = "num_results")
    val numResults: Int,
    @Json(name = "results")
    val results: List<Result>
)
