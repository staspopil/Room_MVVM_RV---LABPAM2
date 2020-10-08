package com.example.labn2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.labn2.Database.ActDatabase
import com.example.labn2.Database.ActViewModel
import com.example.labn2.Database.Repository
import com.example.labn2.databinding.FragmentCreateActBinding
import com.example.labn2.databinding.FragmentListOfActsBinding

class listOfActsFragment : Fragment() {

    private lateinit var actViewModel: ActViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentListOfActsBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_list_of_acts,container,false)

            //RecyclerView
        val recyclerView = binding.recyclerview
        val adapter = listRAdapter()
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(context)
        //ActViewModel
       actViewModel = ViewModelProvider(this).get(ActViewModel::class.java)
        actViewModel.readAlldata.observe(viewLifecycleOwner, Observer { act->
            adapter.setData(act)
        })
        binding.searchButton.setOnClickListener {
            val searchfilter = "%"+binding.filterText.text.toString()+"%"
            actViewModel.getKeyActs(searchfilter)
        }


        return binding.root
    }
}