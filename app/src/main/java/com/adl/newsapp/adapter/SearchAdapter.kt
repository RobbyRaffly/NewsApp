package com.adl.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsapp.R
import com.adl.newsapp.model.ArticlesItem

class SearchAdapter (val data: ArrayList<ArticlesItem>): RecyclerView.Adapter<SearchViewHolder>(){
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        this.parent = parent

        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.article_card,parent,false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bindData(this@SearchAdapter,position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}