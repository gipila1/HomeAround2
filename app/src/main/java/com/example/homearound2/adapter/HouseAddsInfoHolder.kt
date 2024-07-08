package com.example.homearound2.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homearound2.R

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
        val rentorselln: TextView = itemView.findViewById(R.id.RentOrSell)
        val dateleavingn: TextView = itemView.findViewById(R.id.LeavingDate)



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

