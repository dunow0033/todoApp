package com.example.todotake3.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todotake3.adapters.TodoAdapter
import com.example.todotake3.api.ApiManager
import com.example.todotake3.databinding.FragmentTodoBinding
import com.example.todotake3.repository.TodoRepository
import kotlinx.android.synthetic.main.fragment_todo.*

class TodoFragment : Fragment() {

    private var _binding: FragmentTodoBinding? = null
    private val binding: FragmentTodoBinding get() = _binding!!
    private lateinit var viewModel: TodoViewModel

    val TAG = "TodoFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTodoBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            TodoViewModel.TodoViewModelFactory(TodoRepository(ApiManager()))
        ).get(TodoViewModel::class.java)

        binding.todoRv.layoutManager = LinearLayoutManager(requireContext())

        viewModel.todos.observe(viewLifecycleOwner){
            binding.todoRv.adapter = TodoAdapter(it)
        }
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        viewModel = (activity as TodoActivity).viewModel
//        setupRecyclerView()
//
//        viewModel.todos.observe(viewLifecycleOwner, { response ->
//            when (response) {
//                is Resource.Success -> {
//                    hideProgressBar()
//                    response.data?.let { todoList ->
//                        todoAdapter.differ.submitList(todoList)
//                    }
//                }
//                is Resource.Error -> {
//                    hideProgressBar()
//                    response.message?.let { message ->
//                        Log.e(TAG, "An error occurred: $message")
//                    }
//                }
//                is Resource.Loading -> {
//                    showProgressBar()
//                }
//            }
//        })
//    }

//    private fun setupRecyclerView() {
//        todoAdapter = TodoAdapter()
//        todo_rv.apply {
//            adapter = todoAdapter
//            layoutManager = LinearLayoutManager(activity)
//        }
//    }

    private fun showProgressBar() {
        paginationProgressBar.visibility = View.VISIBLE
    }

    private fun hideProgressBar() {
        paginationProgressBar.visibility = View.INVISIBLE
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}