package com.example.labn2.Database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Act::class], version = 2, exportSchema = false)
abstract class ActDatabase : RoomDatabase() {
    abstract fun actDao(): ActDao
    companion object {

        @Volatile
        var INSTANCE: ActDatabase? = null

        fun getDatabase(context: Context): ActDatabase {
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ActDatabase::class.java,
                    "act_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}