package com.adl.newsapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsapp.R
import com.adl.newsapp.adapter.everyAdapter
import com.adl.newsapp.adapter.headlinesAdapter
import com.adl.newsapp.model.everyModel
import com.adl.newsapp.model.headModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    lateinit var lstHeadlines : ArrayList<headModel>
    lateinit var headAdapter: headlinesAdapter
    lateinit var lstevery : ArrayList<everyModel>
    lateinit var evAdapter: everyAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        lstHeadlines = ArrayList<headModel>()
        headAdapter = headlinesAdapter(lstHeadlines)
        lstevery = ArrayList<everyModel>()
        evAdapter = everyAdapter(lstevery)
        getList()
    }

    fun getList(){
        lstHeadlines.clear()
        lstevery.clear()
        lstHeadlines.add(headModel("Top business headlines in the US right now","top-headlines?country=us&category=business"))
        lstHeadlines.add(headModel("Top headlines from TechCrunch right now","top-headlines?sources=techcrunch"))
        lstevery.add(everyModel("All articles mentioning Apple from yesterday, sorted by popular publishers first","everything?q=apple&from=2022-07-02&to=2022-07-02&sortBy=popularity"))
        lstevery.add(everyModel("All articles about Tesla from the last month, sorted by recent first","everything?q=tesla&from=2022-06-03&sortBy=publishedAt"))
        lstevery.add(everyModel("All articles published by the Wall Street Journal in the last 6 months, sorted by recent first","everything?domains=wsj.com"))

        headAdapter.notifyDataSetChanged()
        evAdapter.notifyDataSetChanged()
        rvEverything.apply {
            layoutManager =LinearLayoutManager(activity,LinearLayoutManager.VERTICAL,false)
            adapter = evAdapter
        }


        rvHeadlines.apply{
            layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
            adapter = headAdapter
        }



    }

}