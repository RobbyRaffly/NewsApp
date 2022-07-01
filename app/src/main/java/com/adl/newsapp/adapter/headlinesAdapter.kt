package com.adl.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsapp.R
import com.adl.newsapp.model.headModel

class headlinesAdapter (val data: ArrayList<headModel>): RecyclerView.Adapter<headlinesViewHolder>() {
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): headlinesViewHolder {
        this.parent = parent

        return headlinesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.headlines_card,parent,false))
    }

    override fun onBindViewHolder(holder: headlinesViewHolder, position: Int) {
        holder.bindData(this@headlinesAdapter,position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}