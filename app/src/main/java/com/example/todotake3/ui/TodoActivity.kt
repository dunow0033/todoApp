package com.example.todotake3.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.todotake3.R
import com.example.todotake3.repository.TodoRepository

class TodoActivity : AppCompatActivity(R.layout.activity_todo)
//class TodoActivity : AppCompatActivity() {
//    lateinit var viewModel: TodoViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_todo)
//
//        val todoRepository = TodoRepository()
//        val viewModelProviderFactory = TodoViewModel.TodoViewModelFactory(todoRepository)
//        viewModel = ViewModelProvider(this, viewModelProviderFactory).get(TodoViewModel::class.java)
//
//
//    }
//}