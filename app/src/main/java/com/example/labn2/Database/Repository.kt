package com.example.labn2.Database

//import android.provider.SyncStateContract.Helpers.insert
import androidx.lifecycle.LiveData

class Repository(private val  actDao:ActDao) {



    val readAllData : LiveData<List<Act>> = actDao.getAllActs()


    fun getKeyActs(key:String):LiveData<List<Act>>{
      val l =   actDao.getKeyActs(key)
        return l
    }

      fun addAct(act:Act){
        actDao.addAct(act)
    }

    fun delete(act:Act){
        actDao.delete(act)
    }
    suspend fun update(act:Act){
        actDao.update(act)
    }
     fun get(id: Long):Act?{
        return  actDao.get(id)
    }
    }