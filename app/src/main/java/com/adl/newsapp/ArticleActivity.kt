package com.adl.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsapp.adapter.NewsAdapter
import com.adl.newsapp.model.ArticlesItem
import com.adl.newsapp.model.ResponseArticles
import com.adl.newsapp.model.everyModel
import com.adl.newsapp.model.headModel
import com.adl.newsapp.services.ConfigRetrofit
import kotlinx.android.synthetic.main.activity_article.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ArticleActivity : AppCompatActivity() {
    lateinit var data: everyModel

    lateinit var link:String
    lateinit var lstNews : ArrayList<ArticlesItem>
    lateinit var newsAdapter: NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)
        lstNews = ArrayList<ArticlesItem>()

        newsAdapter = NewsAdapter(lstNews)

        if (intent.hasExtra("data")) {
                data = intent.getParcelableExtra("data")!!
                link = data.link
            getListArticle(link)
        }
    }

    fun getRetrofit(url:String): Call<ResponseArticles> {
        if (url.equals("everything?q=apple&from=2022-07-02&to=2022-07-02&sortBy=popularity")) {
            return ConfigRetrofit().getUser().getApples()
        }else if(url.equals("everything?q=tesla&from=2022-06-03&sortBy=publishedAt")) {
            return ConfigRetrofit().getUser().getTeslas()
        }else if(url.equals("top-headlines?country=us&category=business")) {
            return ConfigRetrofit().getUser().getTopBusiness()
        }else if(url.equals("top-headlines?sources=techcrunch")) {
            return ConfigRetrofit().getUser().getTopTechCrunch()
        }else if(url.equals("everything?domains=wsj.com")) {
            return ConfigRetrofit().getUser().getWSJ()
        }
        return ConfigRetrofit().getUser().getArticle("everything","banana")
    }


    fun getListArticle(url:String){
        getRetrofit(url)
        ?.enqueue(object : Callback<ResponseArticles> {
                override fun onResponse(
                    call: Call<ResponseArticles>,
                    response: Response<ResponseArticles>
                ) {
                    val data: ResponseArticles? = response.body()

                    Toast.makeText(this@ArticleActivity, "Get data berhasil", Toast.LENGTH_LONG)
                        .show()

                    Log.d("sukses", data.toString())

                    for (isi in data?.articles.orEmpty()){
                        lstNews.add(ArticlesItem(isi?.publishedAt,isi?.author,isi?.urlToImage, isi?.description,isi?.source, isi?.title, isi?.url, isi?.content))
                    }
                    newsAdapter.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<ResponseArticles>, t: Throwable) {
                    Toast.makeText(this@ArticleActivity, "Login Gagal", Toast.LENGTH_LONG)
                        .show()
                    Log.d("gagal", t.toString())
                }
            })


        rvArticles.apply{
            layoutManager = LinearLayoutManager(this@ArticleActivity)
            adapter = newsAdapter
        }
    }
}
