package com.example.labn2.Database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class ActViewModel(application: Application):AndroidViewModel(application) {
    var readAlldata: LiveData<List<Act>>
    val repository: Repository
    lateinit var Act:Act

    init {
        val actDao = ActDatabase.getDatabase(application)
            .actDao()
        repository = Repository(actDao)
        readAlldata = repository.readAllData
    }

    fun getKeyActs(key:String){
        this.readAlldata = repository.getKeyActs(key)
    }

    fun addAct(act: Act) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAct(act)
        }
    }

    fun delete(act:Act) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.delete(act)
        }
    }

        fun update(act: Act) {
            viewModelScope.launch(Dispatchers.IO) {
                repository.update(act)
            }
        }

        fun getAct(id:Long):Act?{
            return repository.get(id)
        }
    }



