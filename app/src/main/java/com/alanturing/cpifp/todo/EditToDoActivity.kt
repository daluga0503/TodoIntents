package com.alanturing.cpifp.todo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alanturing.cpifp.todo.data.TaskLocalRepository
import com.alanturing.cpifp.todo.databinding.ActivityTodoEditBinding
import com.alanturing.cpifp.todo.model.Task

class EditToDoActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTodoEditBinding

    override  fun onCreate(savedInstanceState: Bundle?){
        val repository = TaskLocalRepository.getInstance()
        super.onCreate(savedInstanceState)
        binding = ActivityTodoEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val task: Task = intent.extras?.getSerializable("Task") as Task
        var taskId = 0
        if (task!=null){
            taskId = task.id
        }
        binding.tituloActualizadoInput.setText(task.title)
        binding.descriptionActualizadoInput.setText(task.description)
        binding.actualizarBoton.setOnClickListener{
            val task=Task(taskId,binding.tituloActualizadoInput.text.toString(), binding.descriptionActualizadoInput.text.toString(),binding.miCheckbox.isChecked)
            repository.update(task)
            setResult(Activity.RESULT_OK)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.cancelarActualizadoBoton.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}