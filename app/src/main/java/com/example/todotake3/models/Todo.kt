package com.example.todotake3.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class Todo(
    @get:Json(name = "userId")
    val userId: Int,
    @get:Json(name = "id")
    val id: Int,
    @get:Json(name = "title")
    val title: String,
    @get:Json(name = "completed")
    val completed: Boolean
)

