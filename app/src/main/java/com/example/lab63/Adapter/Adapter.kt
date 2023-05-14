package com.example.lab63.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.lab63.R
import com.example.lab63.Contact
import com.example.lab63.ListFragment

class Adapter(private val contacts: ArrayList<Contact>, val context: Context, val callback: ListFragment) :

    RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = contacts[position].name
        holder.lastName.text = contacts[position].lastName
        holder.suffix.text = contacts[position].suffix
        holder.email.text = contacts[position].email
        holder.photo.setImageResource(contacts[position].photo)
        holder.itemRoot.setOnClickListener { callback.onItemSelected(position) }
        holder.editButton.setOnClickListener { callback.onEditSelected(position) }
    }

    override fun getItemCount(): Int {
        return contacts.size
    }
}

class  ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val editButton = itemView.findViewById<ImageView>(R.id.ivEditButton)
    val name = itemView.findViewById<TextView>(R.id.tvName)
    val lastName = itemView.findViewById<TextView>(R.id.tvLastName)
    val suffix = itemView.findViewById<TextView>(R.id.tvSuffix)
    val email = itemView.findViewById<TextView>(R.id.tvEmail)
    val photo = itemView.findViewById<ImageView>(R.id.ivMainPhoto)
    val itemRoot = itemView.findViewById<CardView>(R.id.ListItemRoot)
}

interface Callback{
    fun onItemSelected(i: Int)
}