package com.example.todotake3.ui

import androidx.lifecycle.*

import com.example.todotake3.models.Todo
import com.example.todotake3.models.TodoResponse
import com.example.todotake3.repository.TodoRepository
import com.example.todotake3.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.IllegalArgumentException

class TodoViewModel(private val todoRepository: TodoRepository) : ViewModel() {

    private var _todos : MutableLiveData<List<Todo>> = MutableLiveData()
    val todos: LiveData<Resource<List<Todo>>> get() = _todos
    var start = 0
    var limit = 10

    init {
        getTodos(start, limit)
    }

    private fun getTodos(start: Int, limit: Int){
        viewModelScope.launch {
            val todos = todoRepository.getTodos(start, limit)
            _todos.postValue(handleTodoResponse(todos))
        }
    }

    private fun handleTodoResponse(response: Response<List<Todo>>) : List<Todo> {
        if(response.isSuccessful) {
            response.body()?.let { resultResponse ->
                return resultResponse
            }
        }
        return Resource.Error(response.message())
    }

    class TodoViewModelFactory(
        private val todoRepository: TodoRepository
    ) : ViewModelProvider.Factory {

        override fun <T : ViewModel? > create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(TodoViewModel::class.java)) {
                return TodoViewModel(todoRepository) as T
            } else {
                throw IllegalArgumentException("Could not create instance of TriviaViewModel")
            }
        }
    }
}