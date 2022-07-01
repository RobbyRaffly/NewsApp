package com.adl.newsapp.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsapp.ArticleActivity
import com.adl.newsapp.R
import kotlinx.android.synthetic.main.every_card.view.*
import kotlinx.android.synthetic.main.headlines_card.view.*


class everyViewHolder (view: View): RecyclerView.ViewHolder(view) {

    val title = view.txtEvery
    val navigasi = view.everyCard

    fun bindData(adapter: everyAdapter, position:Int){
        title.setText(adapter.data.get(position)?.teksTitle)


        navigasi.setOnClickListener{
            val intent = Intent(adapter.parent.context, ArticleActivity::class.java)
            intent.putExtra("data",adapter.data.get(position))
            //intent.putExtra("data", adapterPosition)
            adapter.parent.context.startActivity(intent)

        }
    }
}


