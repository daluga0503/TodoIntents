package com.alanturing.cpifp.todo

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alanturing.cpifp.todo.data.TaskLocalRepository
import com.alanturing.cpifp.todo.databinding.ActivityTodoCreateBinding
import com.alanturing.cpifp.todo.model.Task

class CreateToDoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoCreateBinding
    private val repository = TaskLocalRepository.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTodoCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.createBoton.setOnClickListener{
            val task = Task(repository.getNextTaskId(),
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