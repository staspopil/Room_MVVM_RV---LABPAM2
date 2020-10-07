package com.example.labn2

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.example.labn2.Database.Act
import com.example.labn2.Database.ActDatabase
import com.example.labn2.Database.ActViewModel
import com.example.labn2.databinding.FragmentCreateActBinding
import kotlinx.android.synthetic.main.fragment_create_act.*
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateActFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateActFragment : Fragment() {
    var time:String = " "
    private lateinit var timePicker: TimePicker
    private lateinit var actViewModel: ActViewModel


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentCreateActBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_create_act,container,false)
        val view = inflater.inflate(R.layout.fragment_create_act, container,false)
        val args = CreateActFragmentArgs.fromBundle(arguments!!)
        time = args.time
       // val string = SimpleDateFormat("dd/MM/yyyy").format(time)
        actViewModel = ViewModelProvider(this,defaultViewModelProviderFactory).get(ActViewModel::class.java)
         timePicker = binding.timepicker

        binding.sbmitButton.setOnClickListener {
           addDataInDB()
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun addDataInDB() {
        val actTitle = Act_Title.text.toString()
        val actDescription = Act_Description.text.toString()


        if (inputCheck(actTitle,actDescription)){
            val act = Act(0,time,actTitle,actDescription,"${timePicker.hour}:${timePicker.minute}")
           actViewModel.addAct(act)
            Toast.makeText(context,"Succesfully Added" + actTitle,Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_createActFragment_to_listOfActsFragment)
        }
        else {
            Toast.makeText(context,"Fill the all fields",Toast.LENGTH_SHORT).show()
        }
    }

    private  fun inputCheck(title :String, description:String):Boolean{
        return !(TextUtils.isEmpty(title)&&TextUtils.isEmpty(description))
    }
}