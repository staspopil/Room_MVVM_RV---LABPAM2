package com.example.labn2

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.labn2.Database.Act
import com.example.labn2.Database.ActDatabase
import com.example.labn2.Database.ActViewModel
import com.example.labn2.Database.Repository
import com.example.labn2.databinding.ActItemBinding
import com.example.labn2.databinding.ActivityMainBinding
import com.example.labn2.databinding.FragmentListOfActsBinding
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import kotlin.coroutines.coroutineContext
import android.app.Application
import android.provider.ContactsContract
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController


class listRAdapter() :
    RecyclerView.Adapter<listRAdapter.MyViewHolder>() {

    private var myDataset = emptyList<Act>()
    class MyViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.act_item,parent,false)){



        private var titletext: TextView? = null
        private var desctiptiontext: TextView? = null
        private var idText: TextView? = null
        private var timeText:TextView? = null
        private var hhmmText:TextView? = null
        private lateinit var imageDelete:ImageView
        private lateinit var imageEdit:ImageView
        init{
            timeText=itemView.findViewById(R.id.textTime)
            idText = itemView.findViewById(R.id.textID)
            titletext = itemView.findViewById(R.id.textTitle)
            desctiptiontext = itemView.findViewById(R.id.textDescription)
           hhmmText = itemView.findViewById(R.id.text_hh_mm)
            imageDelete = itemView.findViewById(R.id.image_delete)
            imageEdit = itemView.findViewById(R.id.image_edit)

        }
        fun bind(act: Act){
            timeText?.text=act.creatingDate
            idText?.text=act.ActId.toString()
            titletext?.text=act.actName
            desctiptiontext?.text=act.actText
            hhmmText?.text = act.time
            imageEdit.setOnClickListener {
             imageEdit.findNavController().navigate(listOfActsFragmentDirections.actionListOfActsFragmentToEditFragment(act.ActId))
            }
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): listRAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MyViewHolder(inflater,parent)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val act:Act = myDataset.get(position)
        holder.bind(act)
    }
    fun setData(act: List<Act>){
        this.myDataset=act
        notifyDataSetChanged()
    }
    override fun getItemCount() = myDataset.size
}