package com.adl.newsapp.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.news_card.view.*

class NewsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val title = view.titleNews
    val desc = view.newsDesc
    val image = view.NewsImg

    fun bindData(adapter: NewsAdapter, position:Int){
        title.setText(adapter.data.get(position)?.title.toString())
        desc.setText(adapter.data.get(position)?.description.toString())
        image?.let {
            Glide.with(adapter.parent.context)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .load(adapter.data.get(position).urlToImage)
                .into(it)
        }

//        navigasi.setOnClickListener{
//            val intent = Intent(adapter.parent.context, DetailResepActivity::class.java)
//            intent.putExtra("data",adapter.data.get(position))
//            adapter.parent.context.startActivity(intent)
//
//        }


    }
}