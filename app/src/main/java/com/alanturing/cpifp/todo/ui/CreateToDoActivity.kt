package com.alanturing.cpifp.todo.ui

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.alanturing.cpifp.todo.R
import com.alanturing.cpifp.todo.databinding.ActivityTodoCreateBinding
import com.alanturing.cpifp.todo.model.Task

class CreateToDoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTodoCreateBinding
    //private val repository = TaskLocalRepository.getInstance()
    private val viewModel:TaskViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityTodoCreateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.topAppBar)
        binding.topAppBar.setNavigationOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?):Boolean{
        menuInflater.inflate(R.menu.form_menu,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId){
        R.id.save ->{
            val task = Task(viewModel.getNextId(),
                binding.tituloInput.text.toString(),
                binding.descriptionInput.text.toString(), false)
            viewModel.add(task)
            setResult(Activity.RESULT_OK)
            finish()
            //Return true
            true
        }
        else -> false
    }
}