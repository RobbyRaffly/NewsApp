package com.adl.newsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsapp.adapter.NewsAdapter
import com.adl.newsapp.model.ArticlesItem
import com.adl.newsapp.model.ResponseArticles
import com.adl.newsapp.services.ConfigRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var lstNews : ArrayList<ArticlesItem>
    lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lstNews = ArrayList<ArticlesItem>()

        newsAdapter = NewsAdapter(lstNews)

        ConfigRetrofit().getUser()
            .getArticle()
            .enqueue(object : Callback<ResponseArticles> {
                override fun onResponse(
                    call: Call<ResponseArticles>,
                    response: Response<ResponseArticles>
                ) {
                    val data: ResponseArticles? = response.body()

                    Toast.makeText(this@MainActivity, "Login berhasil", Toast.LENGTH_LONG)
                        .show()

                    Log.d("sukses", data.toString())

                    for (isi in data?.articles.orEmpty()){
                        lstNews.add(ArticlesItem(isi?.publishedAt,isi?.author,isi?.urlToImage, isi?.description,isi?.source, isi?.title, isi?.url, isi?.content))
                    }

                    newsAdapter.notifyDataSetChanged()


                    //dataGenerate(data?.data?.adlNews as List<AdlNewsItem>)
//                    val intent = Intent(this@MainActivity, MainMenu::class.java)
//                    startActivity(intent)

                }

                override fun onFailure(call: Call<ResponseArticles>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Login Gagal", Toast.LENGTH_LONG)
                        .show()

                    Log.d("gagal", t.toString())
                }


            })


        rvNews.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = newsAdapter
        }
    }
}