package com.example.homearound2.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.homearound2.DataList1
import com.example.homearound2.R
import com.example.homearound2.rentmodel.HouseAddsInfo

class HouseAddsInfoHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView)  {


        //lateinit var bindingHouseTitle: ActivitySelectionOfPlace2Binding
        val houseView: ImageView = itemView.findViewById(R.id.HouseView)
        val houseTitle: TextView = itemView.findViewById(R.id.HouseTitle)
        val squeredMetrestm: TextView = itemView.findViewById(R.id.NumberHouseSqueredmetres)
        val costofrent: TextView = itemView.findViewById(R.id.CostOfRentPrice)
        val housePlacenew: TextView = itemView.findViewById(R.id.HousePlaceall)
        val floorn: TextView = itemView.findViewById(R.id.Floor)
        val yearconstructednum: TextView = itemView.findViewById(R.id.YearConstructed)



    }


    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HouseAddsInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent , false)
        return HouseAddsInfoViewHolder(view) // to check
    }

    override fun onBindViewHolder(holder: HouseAddsInfoViewHolder, position: Int) {
        val house : HouseAddsInfo = houseList1[position]
        //holder.houseView.setImageResource(house.image)
        holder.houseTitle.text = house.houseName
        holder.housePlacenew.text = house.housePlace
        holder.squeredMetrestm.text= house.squeredMetres.toString()
        holder.costofrent.text= house.costOfRent.toString()
        holder.floorn.text= house.floor
        holder.yearconstructednum.text= house.yearConstructed.toString()



        holder.itemView.setOnClickListener{
            onItemClick?.invoke(listOf(house))

        }
    }


    override fun getItemCount(): Int {
        return houseList1.size
    }
*/

