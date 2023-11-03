package com.alanturing.cpifp.todo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alanturing.cpifp.todo.data.TaskLocalRepository
import com.alanturing.cpifp.todo.databinding.TodoItemBinding
import com.alanturing.cpifp.todo.model.Task

class TasksAdapter(val datos:List<Task>,
                   val onShare:((t:Task, v:View)->Unit)): RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {
    inner class TaskViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindTask(t:Task){
            //TODO("Asignar los elementos de pantalla")
            binding.title.text = t.title
            binding.description.text = t.description
            binding.switchItem.isChecked = t.isCompleted
            binding.compartirButton.setOnClickListener{
                onShare(t,it)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = TodoItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false,)
        return TaskViewHolder(binding)
    }

    override fun getItemCount(): Int {
        //TODO("Not yet implemented")
        return datos.size
    }

    //inyeccion formulario en la lista de tareas
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        //TODO("Not yet implemented")
        val task  = datos[position]
        holder.bindTask(task)

    }
}