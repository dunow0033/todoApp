package com.example.todotake3.api

import com.example.todotake3.models.Todo
import com.example.todotake3.models.TodoResponse
import retrofit2.Response

class ApiManager {

    private val todoService : TodoService
    private val retrofit = RetrofitInstance.providesRetrofit()

    init {
        todoService = retrofit.create(TodoService::class.java)
    }

    suspend fun getTodos() : Response<List<Todo>> {
        return todoService.getTodos(0, 10)
    }
}