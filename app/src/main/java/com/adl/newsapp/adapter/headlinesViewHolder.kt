package com.adl.newsapp.adapter

import android.content.Intent
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.adl.newsapp.HeadLineActivity
import kotlinx.android.synthetic.main.headlines_card.view.*


class headlinesViewHolder (view: View): RecyclerView.ViewHolder(view) {
    val title = view.txtHeadline
    val navigasi = view.headlinesCard

    fun bindData(adapter: headlinesAdapter, position:Int){
        title.setText(adapter.data.get(position)?.teksTitle)


        navigasi.setOnClickListener{
            val intent = Intent(adapter.parent.context, HeadLineActivity::class.java)
            intent.putExtra("data",adapter.data.get(position))
            //intent.putExtra("data", adapterPosition)
            adapter.parent.context.startActivity(intent)

        }
    }
}