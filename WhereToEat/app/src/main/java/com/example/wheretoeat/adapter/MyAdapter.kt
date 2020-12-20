package com.example.wheretoeat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretoeat.R.layout.row_layout
import com.example.wheretoeat.model.Post
import kotlinx.android.synthetic.main.row_layout.view.*
import com.example.wheretoeat.model.Restaurants


class MyAdapter:  RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Restaurants>()

    inner class MyViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(row_layout, parent, false))

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            holder.itemView.RestaurantName_txt.text = myList[position].nameRes
            holder.itemView.CityName_txt.text = myList[position].city
            holder.itemView.RestaurantAddress_txt.text = myList[position].addressRes
            holder.itemView.RestaurantPhone_txt.text = myList[position].phoneRes
    }


    fun setData() {
        myList = mutableListOf()
        notifyDataSetChanged()
    }





}