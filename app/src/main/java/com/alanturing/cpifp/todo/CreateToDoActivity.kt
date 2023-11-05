package com.alanturing.cpifp.todo

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alanturing.cpifp.todo.data.TaskLocalRepository
import com.alanturing.cpifp.todo.databinding.ActivityTodoCreateBinding
import com.alanturing.cpifp.todo.model.Task

class CreateToDoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoCreateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        val repository = TaskLocalRepository.getInstance()
        super.onCreate(savedInstanceState)
        binding = ActivityTodoCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createBoton.setOnClickListener{
            val task = Task(taskId,
                binding.tituloInput.text.toString(),
                binding.descriptionInput.text.toString(), false)
            repository.add(task)
            setResult(Activity.RESULT_OK)
            finish()
        }
        binding.cancelBoton.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
    }
}