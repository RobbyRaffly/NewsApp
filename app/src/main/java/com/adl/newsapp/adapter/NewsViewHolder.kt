package com.adl.newsapp.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsapp.WebViewActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.article_card.view.*
import kotlinx.android.synthetic.main.headlines_card.view.*
import kotlinx.android.synthetic.main.news_card.view.*

class NewsViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val title = view.titleArticle
    val image = view.ArticleImg
    val navigasi = view.arcticleCard

    fun bindData(adapter: NewsAdapter, position:Int){
        title.setText(adapter.data.get(position)?.title.toString())
       // desc.setText(adapter.data.get(position)?.description.toString())
        image?.let {
            Glide.with(adapter.parent.context)
                .asBitmap()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .skipMemoryCache(true)
                .load(adapter.data.get(position).urlToImage)
                .into(it)
        }

        navigasi.setOnClickListener{
            val intent = Intent(adapter.parent.context, WebViewActivity::class.java)
            intent.putExtra("data",adapter.data.get(position))
            adapter.parent.context.startActivity(intent)

        }


    }
}