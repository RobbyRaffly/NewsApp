package com.adl.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsapp.R
import com.adl.newsapp.model.ArticlesItem
import com.adl.newsapp.model.NewsModel

class NewsAdapter(val data: ArrayList<ArticlesItem>): RecyclerView.Adapter<NewsViewHolder>() {
    lateinit var parent: ViewGroup
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        this.parent = parent

        return NewsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.article_card,parent,false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bindData(this@NewsAdapter,position)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}