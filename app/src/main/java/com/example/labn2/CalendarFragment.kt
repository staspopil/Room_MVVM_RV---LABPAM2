package com.example.labn2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CalendarView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.labn2.Database.ActViewModel
import com.example.labn2.databinding.FragmentCalendarBinding
import java.text.SimpleDateFormat
import java.util.*


class CalendarFragment : Fragment() {
        var time:String = " "
      private lateinit var  calendar: CalendarView
    private lateinit var actViewModel: ActViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding:FragmentCalendarBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_calendar,container,false)
        calendar = binding.calendarView
        calendar.setOnDateChangeListener { view, year, month, dayOfMonth ->
             time = "$dayOfMonth.${month + 1}.$year"
        }



    binding.showButton.setOnClickListener{
       findNavController().navigate(R.id.action_calendarFragment_to_listOfActsFragment)
    }
        binding.addButton.setOnClickListener{
            var date = calendar.date
            findNavController().navigate(CalendarFragmentDirections.actionCalendarFragmentToCreateActFragment(time))
        }


        return binding.root
    }
}