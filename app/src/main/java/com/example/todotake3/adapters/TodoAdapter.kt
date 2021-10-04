package com.example.todotake3.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todotake3.databinding.ListItemTodoBinding
import com.example.todotake3.models.Todo
import com.example.todotake3.utils.Resource

//class TodoAdapter() : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
//    private val differCallback = object : DiffUtil.ItemCallback<Todo>() {
//        override fun areItemsTheSame(oldItem: Todo, newItem: Todo): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Todo, newItem: Todo): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    val differ = AsyncListDiffer(this, differCallback)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
//        return TodoViewHolder(
//            ListItemTodoBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
//        holder.onBind(differ.currentList[position])
//    }
//
//    override fun getItemCount(): Int {
//        return differ.currentList.size
//    }
//
//    class TodoViewHolder(
//        private val binding: ListItemTodoBinding) : RecyclerView.ViewHolder(binding.root){
//        fun onBind(todo: Todo) {
//            with(binding) {
//                title.text = todo.title
//                completeStatus.text = todo.completed.toString()
//            }
//        }
//    }
//
//}

class TodoAdapter(
    private val todoList: List<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(
        private val binding: ListItemTodoBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(todo: Todo) {
            with(binding) {
                title.text = todo.title
                completeStatus.text = todo.completed.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            ListItemTodoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.onBind(todoList[position])
    }

    override fun getItemCount(): Int {
        return todoList.size
    }
}