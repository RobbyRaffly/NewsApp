package com.adl.newsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.adl.newsapp.model.ArticlesItem

class WebViewActivity : AppCompatActivity() {
    lateinit var data:ArticlesItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)
        val myWebView = WebView(this@WebViewActivity)
        setContentView(myWebView)
        if(intent.hasExtra("data")) {
            data = intent.getParcelableExtra("data")!!
            data.url?.let { myWebView.loadUrl(it) }
        }
        //myWebView.loadUrl("https://www.theverge.com/2022/7/2/23190004/tesla-record-quarterly-deliveries-end-china-covid-shutdowns")
    }
}