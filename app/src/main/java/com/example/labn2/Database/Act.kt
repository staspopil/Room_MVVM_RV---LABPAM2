package com.example.labn2.Database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey



    @Entity(tableName = "act_table")
    data class Act(
        @PrimaryKey(autoGenerate = true)
        var ActId: Long ,

       // @ColumnInfo(name = "start_time_milli")
        val creatingDate: String,

      //  @ColumnInfo(name = "act_name")
        var actName: String ,

     //   @ColumnInfo(name = "act_text")
        var actText: String,

        var time: String
    )
