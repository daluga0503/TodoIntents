package com.alanturing.cpifp.todo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alanturing.cpifp.todo.databinding.TodoItemBinding
import com.alanturing.cpifp.todo.model.Task

class TasksAdapter(private val datos:List<Task>,
                   val onShare:((t:Task, v:View)->Unit),
                   val onEdit: ((t:Task)->Unit)): RecyclerView.Adapter<TasksAdapter.TaskViewHolder>() {
    inner class TaskViewHolder(val binding: TodoItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bindTask(t:Task){
            //TODO("Asignar los elementos de pantalla")
            binding.title.text = t.title
            binding.description.text = t.description
            binding.switchItem.isChecked = t.isCompleted
            binding.compartirButton.setOnClickListener{
                onShare(t,it)
            }
            binding.editarButton.setOnClickListener{
                onEdit(t)
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
        //return repository.tasks.size
        return datos.size
    }

    //inyeccion formulario en la lista de tareas
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        //TODO("Not yet implemented")
        //holder.bindTask(repository.tasks[position])
        val task = datos[position]
        holder.bindTask(task)

    }
}