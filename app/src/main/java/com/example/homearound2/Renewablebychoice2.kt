package com.example.homearound2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.homearound2.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

/*class Renewablebychoice2 (
    private val adsByPlace: MutableList<DatalList1>
) : RecyclerView.Adapter<Renewablebychoice2.DataListViewHolder>  (){


    class DataListViewHolder(adsView: View) : RecyclerView.ViewHolder(adsView)

    private lateinit var binding: ActivityMainBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataListViewHolder {

        //binding = ActivityMainBinding.inflate(layoutInflater)
        return DataListViewHolder(

          LayoutInflater.from(parent.context).inflate(
                R.layout.item_placesapperance,
                parent,
                false

            )
        )
    }
    override fun getItemCount(): Int {
        return adsByPlace.size

    }
    override fun onBindViewHolder(holder: DataListViewHolder, position: Int) {
        val curTodo = adsByPlace[position]

        holder.itemView.apply {







        }





    }
}*/