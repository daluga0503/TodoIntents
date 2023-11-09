package com.alanturing.cpifp.todo.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alanturing.cpifp.todo.data.TaskLocalRepository
import com.alanturing.cpifp.todo.model.Task

class TaskViewModel(): ViewModel() {
    //sirve como puente en tre la fuente y el repositorio
    private val repository = TaskLocalRepository.getInstance()
    private val _data : MutableLiveData<List<Task>> = MutableLiveData()

    val data: LiveData<List<Task>>
        get() = _data

    init{
        fetchTask()
    }
    fun fetchTask(){
        _data.value = repository.tasks
    }

    fun add(task : Task){
        repository.add(task)
        fetchTask()
    }

    fun getNextTaskId() = repository.getNextTaskId()
}