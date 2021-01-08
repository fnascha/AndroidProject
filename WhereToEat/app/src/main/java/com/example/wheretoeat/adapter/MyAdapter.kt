package com.example.wheretoeat.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wheretoeat.R
import com.example.wheretoeat.R.layout.row_layout
import kotlinx.android.synthetic.main.row_layout.view.*
import com.example.wheretoeat.model.Restaurants
import com.bumptech.glide.Glide

class MyAdapter:  RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private var myList = emptyList<Restaurants>()

    inner class MyViewHolder(itemView: View) :  RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.RestaurantPic)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =  MyViewHolder(LayoutInflater.from(parent.context).inflate(row_layout, parent, false))


        return view

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

            holder.itemView.RestaurantName_txt.text = myList[position].nameRes
            holder.itemView.CityName_txt.text = myList[position].city
            holder.itemView.RestaurantAddress_txt.text = myList[position].addressRes
            holder.itemView.RestaurantPhone_txt.text = myList[position].phoneRes

        Glide.with(holder.itemView.context)
                .load(myList[position].image_url.toString())
                .placeholder(R.drawable.ic_baseline_search_24)
                .error(R.drawable.logo)
                .override(400, 400)
                .centerCrop()
                .into(holder.image)




    }

    fun setData(newList: List<Restaurants>) {
        myList = newList
        notifyDataSetChanged()
    }





}