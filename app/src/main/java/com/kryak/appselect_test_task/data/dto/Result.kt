package com.kryak.appselect_test_task.data.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Result(
    @Json(name = "display_title")
    val displayTitle: String,
    @Json(name = "mpaa_rating")
    val mpaaRating: String,
    @Json(name = "critics_pick")
    val criticsPick: Int,
    @Json(name = "byline")
    val byline: String,
    @Json(name = "headline")
    val headline: String,
    @Json(name = "summary_short")
    val summaryShort: String,
    @Json(name = "publication_date")
    val publicationDate: String,
    @Json(name = "opening_date")
    val openingDate: String?,
    @Json(name = "date_updated")
    val dateUpdated: String,
    @Json(name = "link")
    val link: Link,
    @Json(name = "multimedia")
    val multimedia: Multimedia
)
