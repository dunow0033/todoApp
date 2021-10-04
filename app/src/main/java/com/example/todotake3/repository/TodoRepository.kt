package com.example.todotake3.repository

import android.util.Log
import android.widget.Toast
import com.example.todotake3.api.ApiManager
import com.example.todotake3.api.RetrofitInstance
import com.example.todotake3.api.TodoService
import com.example.todotake3.models.Todo
import com.example.todotake3.models.TodoResponse
import com.example.todotake3.ui.TodoViewModel
import retrofit2.Response

class TodoRepository(private val apiManager: ApiManager) {

    suspend fun getTodos() : List<Todo>  {
        return try {
            val response = apiManager.getTodos()
            if(response.isSuccessful && response.body() != null){
                response.body()!!
            } else {
                emptyList()
            }
        } catch (ex: Exception) {
            Log.d(TAG, ex.toString())
            emptyList()
        }
    }

    companion object {
        private val TAG = TodoRepository::class.java.name
    }
}