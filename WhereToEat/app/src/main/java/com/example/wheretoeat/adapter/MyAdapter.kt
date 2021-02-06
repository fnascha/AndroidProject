package com.example.wheretoeat.adapter
import android.util.Log
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
        val RestaurantsImage: ImageView = itemView.findViewById(R.id.RestaurantPic)
        val RestaurantsName: TextView = itemView.findViewById(R.id.RestaurantName_txt)
        val CityName: TextView = itemView.findViewById(R.id.CityName_txt)
        val RestaurantAddress: TextView = itemView.findViewById(R.id.RestaurantAddress_txt)
        val RestaurantPhone: TextView = itemView.findViewById(R.id.RestaurantPhone_txt)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
                LayoutInflater.from(parent.context).inflate(R.layout.row_layout, parent, false)
        return MyViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return myList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        //Log.d("adapt","resName:$myList[position].nameRes")
            holder.RestaurantsName.text = myList[position].nameRes
            holder.CityName.text = myList[position].city
        //Log.d("adapt","addressRes:$myList[position].addressRes")
            holder.RestaurantAddress.text = myList[position].addressRes
        //Log.d("adapt","phoneRes:$myList[position].phoneRes")
            holder.RestaurantPhone.text = myList[position].phoneRes

        Glide.with(holder.itemView.context)
                .load(myList[position].image_url.toString())
                .placeholder(R.drawable.ic_baseline_search_24)
                .error(R.drawable.logo)
                .override(400, 400)
                .centerCrop()
                .into(holder.RestaurantsImage)

    }

    fun setData(newList: List<Restaurants>) {
        myList = newList
        notifyDataSetChanged()
    }


}