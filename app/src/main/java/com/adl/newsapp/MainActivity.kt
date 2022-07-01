package com.adl.newsapp

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.adl.newsapp.adapter.NewsAdapter
import com.adl.newsapp.fragment.HomeFragment
import com.adl.newsapp.fragment.SearchFragment
import com.adl.newsapp.model.ArticlesItem
import com.adl.newsapp.model.ResponseArticles
import com.adl.newsapp.services.ConfigRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private val homeFragment = HomeFragment()
    private val searchFragment = SearchFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replacementFragment(homeFragment)
        setFullscreen()

        bottom_navigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.ic_home -> replacementFragment(homeFragment)
                R.id.ic_search -> replacementFragment(searchFragment)
            }
            true
        }
    }

    private fun replacementFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }

    fun setFullscreen(){
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
    }
}