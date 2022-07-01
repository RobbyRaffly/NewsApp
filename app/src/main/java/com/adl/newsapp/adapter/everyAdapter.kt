package com.adl.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsapp.R
import com.adl.newsapp.model.everyModel
import com.adl.newsapp.model.headModel


class everyAdapter (val data: ArrayList<everyModel>): RecyclerView.Adapter<everyViewHolder>() {
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): everyViewHolder {
        this.parent = parent

        return everyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.every_card,parent,false))
    }

    override fun onBindViewHolder(holder: everyViewHolder, position: Int) {
        holder.bindData(this@everyAdapter,position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}