package com.example.labn2.Database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ActDao {

    @Delete
    fun delete(act:Act)

    
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addAct(act:Act)

    @Update
    suspend fun update(act: Act)

    @Query("SELECT * from act_table WHERE ActId = :key")
     fun get(key: Long): Act?

    @Query("SELECT * from act_table ORDER BY ActId ASC")
    fun getAllActs(): LiveData<List<Act>>

    @Query("SELECT * from act_table WHERE actName LIKE :key ORDER BY ActId ASC")
    fun getKeyActs(key:String): LiveData<List<Act>>

}