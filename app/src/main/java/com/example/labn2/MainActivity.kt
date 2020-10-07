package com.example.labn2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.room.Room
import com.example.labn2.Database.ActDatabase
import com.example.labn2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         lateinit var database : ActDatabase
        var binding:ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        setContentView(binding.root)
    }

    
}