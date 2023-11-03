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
        _tasks.add(task)
    }
    fun delete(id:Int) {
        //TODO("Código eliminar tarea por id")
    }
    fun update(task:Task) {
        //TODO("Código actualizar tarea con id==id")
    }

    fun getNextTaskId():Int {
        return ++ contadorId
    }
}