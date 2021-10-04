package com.example.todotake3.repository

import android.util.Log
import android.widget.Toast
import com.example.todotake3.api.ApiManager
import com.example.todotake3.api.RetrofitInstance
import com.example.todotake3.api.TodoService
import com.example.todotake3.models.TodoResponse

class TodoRepository() {

    suspend fun getTodos(start: Int, limit: Int) =
        RetrofitInstance.api.getTodos(start, limit)
//    suspend fun getTodos(start: Int, limit: Int): TodoResponse? {
//        return try {
//            val response = apiManager.getTodos()
//            if(response.isSuccessful && response.body() != null) {
//                response.body()!!
//            } else {
//                return null
//            }
//        } catch (ex: Exception) {
//            Log.d(TAG, ex.toString())
//            return null
//        }
//    }
//
//    companion object {
//        private val TAG = TodoRepository::class.java.name
//    }
}