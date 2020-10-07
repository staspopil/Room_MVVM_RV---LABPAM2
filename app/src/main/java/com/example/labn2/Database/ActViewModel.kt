package com.example.labn2.Database

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

abstract class ActViewModel(application: Application):AndroidViewModel(application) {

    val readAlldata: LiveData<List<Act>>
    val repository: Repository

    init {
        val actDao = ActDatabase.getDatabase(application)
            .actDao()
        repository = Repository(actDao)
        readAlldata = repository.readAllData
    }

    fun addAct(act: Act) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.addAct(act)
        }
    }
//
//    fun delete(act: Act) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.delete(act)
//        }
//    }
//
//    fun update(act: Act) {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.update(act)
//        }
//    }
//
//    fun get(id: Long):Act? {
//        val lAct = readAlldata.value
//        val Act = lAct?.get(id.toInt())
//return Act
//    }
}
