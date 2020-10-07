package com.example.labn2.Database

//import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.LiveData

class Repository(private val  actDao:ActDao) {



    val readAllData : LiveData<List<Act>> = actDao.getAllActs()


      fun addAct(act:Act){
        actDao.addAct(act)
    }

    fun delete(id:Long){
        actDao.delete(id)
    }
    suspend fun update(act:Act){
        actDao.update(act)
    }
//     fun get(id: Long):Act?{
//        return  actDao.get(id)
//    }
    }