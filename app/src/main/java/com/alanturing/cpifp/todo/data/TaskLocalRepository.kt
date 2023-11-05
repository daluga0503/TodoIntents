package com.alanturing.cpifp.todo.data

import com.alanturing.cpifp.todo.model.Task

class TaskLocalRepository() {
    companion object {
        private var _INSTANCE:TaskLocalRepository? = null
        fun getInstance():TaskLocalRepository {
            if (_INSTANCE == null){
                _INSTANCE = TaskLocalRepository()
            }
            return _INSTANCE!!
        }
    }
    private var contadorId:Int = 0

    private val _tasks = mutableListOf<Task>()




    val tasks:List<Task>
        get() = _tasks

    fun add(task:Task) {
        //TODO("Código crear tarea")
        task.id = contadorId++
        this._tasks.add(task)
    }
    fun delete(id:Int) {
        //TODO("Código eliminar tarea por id")
    }
    fun update(task:Task) {
        val tareaParaActualizar:Task? = _tasks.find { t -> t.id == task.id }
        if (tareaParaActualizar!=null){
            val index = _tasks.indexOf(tareaParaActualizar)
            if (index != -1){
                _tasks[index]= task
            }
        }
    }
}