package com.adl.newsapp.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsapp.R
import com.adl.newsapp.adapter.SearchAdapter
import com.adl.newsapp.model.ArticlesItem
import com.adl.newsapp.model.ResponseArticles
import com.adl.newsapp.services.ConfigRetrofit
import kotlinx.android.synthetic.main.fragment_search.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchFragment : Fragment() {
    lateinit var searchString:String
    lateinit var searchAdapter: SearchAdapter
    lateinit var lstSearch:ArrayList<ArticlesItem>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lstSearch = ArrayList<ArticlesItem>()
        searchAdapter = SearchAdapter(lstSearch)

       // searchString=txtSearch.text.toString()

        btnSearch.setOnClickListener{
                Search()
        }

    }

    fun Search(){
        ConfigRetrofit().getUser().Search(txtSearch.text.toString(),"2022-07-02","2022-07-02","popularity")?.enqueue(object :
            Callback<ResponseArticles> {
            override fun onResponse(
                call: Call<ResponseArticles>,
                response: Response<ResponseArticles>
            ) {
                val data: ResponseArticles? = response.body()

                Toast.makeText(activity, "Search data berhasil", Toast.LENGTH_LONG)
                    .show()

                Log.d("sukses", data.toString())

                for (isi in data?.articles.orEmpty()) {
                    lstSearch.add(
                        ArticlesItem(
                            isi?.publishedAt,
                            isi?.author,
                            isi?.urlToImage,
                            isi?.description,
                            isi?.source,
                            isi?.title,
                            isi?.url,
                            isi?.content
                        )
                    )
                }
                searchAdapter.notifyDataSetChanged()
                rvSearch.apply {
                    layoutManager = LinearLayoutManager(activity)
                    adapter = searchAdapter
                }
            }

            override fun onFailure(call: Call<ResponseArticles>, t: Throwable) {
                Toast.makeText(activity, "Login Gagal", Toast.LENGTH_LONG)
                    .show()
                Log.d("gagal", t.toString())


             }
            }
        )
    }
}
