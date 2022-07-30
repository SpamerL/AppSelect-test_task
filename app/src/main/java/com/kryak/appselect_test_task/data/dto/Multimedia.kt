package com.kryak.appselect_test_task.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Multimedia(
    @Json(name = "type")
    val type: String,
    @Json(name = "src")
    val src: String,
    @Json(name = "height")
    val height: Int,
    @Json(name = "width")
    val width: Int
)
