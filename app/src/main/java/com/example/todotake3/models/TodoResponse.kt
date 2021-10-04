package com.example.todotake3.models

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TodoResponse(
    val todos: List<Todo>
)
