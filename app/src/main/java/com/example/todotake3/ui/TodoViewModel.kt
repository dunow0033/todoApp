package com.example.todotake3.ui

import android.util.Log
import androidx.lifecycle.*

import com.example.todotake3.models.Todo
import com.example.todotake3.models.TodoResponse
import com.example.todotake3.repository.TodoRepository
import com.example.todotake3.utils.Resource
import kotlinx.coroutines.launch
import retrofit2.Response
import java.lang.IllegalArgumentException

class TodoViewModel(private val todoRepository: TodoRepository) : ViewModel() {

    companion object {
        private val TAG = TodoViewModel::class.java.name
    }

    private var _todos : MutableLiveData<List<Todo>> = MutableLiveData()
    val todos: LiveData<List<Todo>> get() = _todos


    init {
        getTodos()
    }

    private fun getTodos(){
        viewModelScope.launch {
            val todos = todoRepository.getTodos()
            _todos.postValue(todos)
        }
    }

//    private fun handleTodoResponse(response: Response<List<Todo>>) : List<Todo> {
////        if(response.isSuccessful) {
////            response.body()?.let { resultResponse ->
////                return resultResponse
////            }
////        } else {
////            return emptyList()
////        }
//
//        return try {
//            if(response.isSuccessful && response.body() != null){
//                response.body()!!
//            } else {
//                emptyList()
//            }
//        } catch (ex: Exception) {
//            Log.d(TAG, ex.toString())
//            emptyList()
//        }
//    }

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