package com.kryak.appselect_test_task.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Link(
    @Json(name = "type")
    val type: String,
    @Json(name = "url")
    val url: String,
    @Json(name = "suggested_link_text")
    val suggestedLinkText: String
)
