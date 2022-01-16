package com.example.authenticatedapi.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.authenticatedapi.R
import com.example.authenticatedapi.models.Users

class MainAdapter( val listData:List<Users> ) : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layouts, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(listData[position])
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    class MainViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(users: Users){
           val firstName=itemView.findViewById<TextView>(R.id.textFname)
            val lastName=itemView.findViewById<TextView>(R.id.textLname)

            firstName.text=users.firstname
            lastName.text=users.lastname

        }
    }

}