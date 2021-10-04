package com.example.todotake3.api

import com.example.todotake3.models.Todo
import com.example.todotake3.models.TodoResponse
import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Query

interface TodoService {
    @GET("todos")

    suspend fun getTodos(
        @Query("_start")
        start: Int = 0,
        @Query("_limit")
        limit: Int = 10
    ) : Response<List<Todo>>
}