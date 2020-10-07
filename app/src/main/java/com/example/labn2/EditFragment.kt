package com.example.labn2

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
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.labn2.Database.Act
import com.example.labn2.Database.ActViewModel
import com.example.labn2.databinding.FragmentCreateActBinding
import com.example.labn2.databinding.FragmentEditBinding
import kotlinx.android.synthetic.main.fragment_edit.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditFragment : Fragment() {

   private var actID :Long = 0
    private lateinit var act:Act
    private lateinit var actViewModel: ActViewModel
    private lateinit var timePicker: TimePicker

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: FragmentEditBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_edit,container,false)
        val view = inflater.inflate(R.layout.fragment_edit, container,false)
        val args = EditFragmentArgs.fromBundle(arguments!!)
        actID = args.id
        actViewModel = ViewModelProvider(this).get(ActViewModel::class.java)
        timePicker = binding.timepicker
        binding.sbmitButton2.setOnClickListener {
            updateAct()
        }
        binding.delButton.setOnClickListener {
            actViewModel.delete(actID)
            findNavController().navigate(R.id.action_editFragment_to_listOfActsFragment)
        }
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun updateAct() {
        val actTitle = Act_Title2.text.toString()
        val actDescription = Act_Description2.text.toString()
        val actDate = Act_Date2.text.toString()
        if (inputCheck(actTitle,actDescription)){
            val act = Act(actID,actDate,actTitle,actDescription,"${timePicker.hour}:${timePicker.minute}")
            actViewModel.update(act)
            Toast.makeText(context,"Succesfully Edited" + actTitle, Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_editFragment_to_listOfActsFragment)
        }
        else {
            Toast.makeText(context,"Fill the all fields", Toast.LENGTH_SHORT).show()
        }
    }

    private  fun inputCheck(title :String, description:String):Boolean{
        return !(TextUtils.isEmpty(title)&& TextUtils.isEmpty(description))
    }
}


