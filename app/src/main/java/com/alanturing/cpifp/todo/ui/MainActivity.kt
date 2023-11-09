package com.alanturing.cpifp.todo.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.alanturing.cpifp.todo.R
import com.alanturing.cpifp.todo.adapter.TasksAdapter
import com.alanturing.cpifp.todo.databinding.ActivityMainBinding
import com.alanturing.cpifp.todo.model.Task

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    // ya no hace falta por el viewModel private val repository = TaskLocalRepository.getInstance()
    private val viewModel:TaskViewModel by viewModels()
    /*
    private val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        when (it.resultCode){
            Activity.RESULT_OK ->{
                binding.tasks.adapter = TasksAdapter(viewModel.data.value!!,::onShareItem,::onEditItem)
            }
            Activity.RESULT_CANCELED -> {
                Snackbar.make(this, binding.root, "Se ha cancelado", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.topAppBar)

        binding.tasks.adapter = TasksAdapter(viewModel.data.value!!,::onShareItem,::onEditItem)
        val taskObserver = Observer<List<Task>>{}
        viewModel.data.observe(this, taskObserver)


        //TODO("Recuperar el RecyclerView y asignar el adaptador")
        binding.floatingButton.setOnClickListener{
            //Manejamos la pulsación del botón
            val createIntent = Intent(this, CreateToDoActivity::class.java)
            //startActivityForResult(createIntent, 1)
            //startActivity(createIntent)
            //getResult.launch(createIntent)
            startActivity(createIntent)
        }
    }

    private fun onShareItem(task: Task, view:View){
        val statusText = if(task.isCompleted) "Completada"
                        else "pendiente"
        val shareText = getString(R.string.share_text, task.title, task.description, statusText)
        val intent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, shareText )
            type = "text/plain"
        }
        val shareIntent = Intent.createChooser(intent, null)
        startActivity(shareIntent)
    }

    private fun onEditItem(task: Task){
        val editIntent = Intent(this, EditToDoActivity::class.java)
        val bundle = Bundle()
        bundle.putParcelable("Task", task)
        editIntent.putExtras(bundle)
        startActivity(editIntent)
    }


    override fun onResume(){
        super.onResume()
        // binding.tasks.adapter = TasksAdapter(TaskLocalRepository.getInstance().tasks)
    }

}