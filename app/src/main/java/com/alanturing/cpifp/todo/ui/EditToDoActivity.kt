package com.alanturing.cpifp.todo.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.alanturing.cpifp.todo.R
import com.alanturing.cpifp.todo.data.TaskLocalRepository
import com.alanturing.cpifp.todo.databinding.ActivityTodoEditBinding
import com.alanturing.cpifp.todo.model.Task

class EditToDoActivity: AppCompatActivity() {
    private lateinit var binding: ActivityTodoEditBinding
    private val repository = TaskLocalRepository.getInstance()

    override  fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityTodoEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)
        binding.topAppBar.setNavigationOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        val task: Task? = intent?.extras?.getParcelable("Task")
        var taskId = 0
        if (task!=null){
            taskId = task.id
        }
        binding.tituloActualizadoInput.setText(task?.title)
        binding.descriptionActualizadoInput.setText(task?.description)
        /*
        binding.actualizarBoton.setOnClickListener{
            val task=Task(taskId,binding.tituloActualizadoInput.text.toString(), binding.descriptionActualizadoInput.text.toString(),binding.miCheckbox.isChecked)
            repository.update(task)
            setResult(Activity.RESULT_OK)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        */
        /*
        binding.cancelarActualizadoBoton.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }
        */
    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.form_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        R.id.save ->{
            val task=Task(taskId,binding.tituloActualizadoInput.text.toString(), binding.descriptionActualizadoInput.text.toString(),binding.miCheckbox.isChecked)
            repository.update(task)
            setResult(Activity.RESULT_OK)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
            true
        }
        else -> false
    }
}