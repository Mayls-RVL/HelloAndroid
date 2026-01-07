package com.example.miniprofile

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val title: TextView = itemView.findViewById(R.id.itemTitle)
    val arrow: ImageView = itemView.findViewById(R.id.itemArrow)
}
