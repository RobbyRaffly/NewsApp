package com.adl.newsapp.services

import com.adl.newsapp.model.ResponseArticles
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface InterfaceUser {

    @Headers("x-api-key:975b651e722640579883da60120b54fc")
    @GET("v2/everything")
    fun Search(@Query("q")q:String,@Query("from")from:String,@Query("to")to:String,@Query("sortBy")sortBy:String): Call<ResponseArticles>

    @Headers("x-api-key:975b651e722640579883da60120b54fc")
    @GET("v2/{key}")
    fun getArticle(@Path("key")key: String,@Query("q")q:String): Call<ResponseArticles>


    @Headers("x-api-key:975b651e722640579883da60120b54fc")
    @GET("v2/everything?q=apple&from=2022-06-30&to=2022-06-30&sortBy=popularity")
    fun getApples(): Call<ResponseArticles>

    @Headers("x-api-key:975b651e722640579883da60120b54fc")
    @GET("v2/everything?q=tesla&from=2022-06-03&sortBy=publishedAt")
    fun getTeslas(): Call<ResponseArticles>

    @Headers("x-api-key:975b651e722640579883da60120b54fc")
    @GET("v2/top-headlines?country=us&category=business&apiKey=975b651e722640579883da60120b54fc")
    fun getTopBusiness(): Call<ResponseArticles>

    @Headers("x-api-key:975b651e722640579883da60120b54fc")
    @GET("v2/top-headlines?sources=techcrunch&apiKey=975b651e722640579883da60120b54fc")
    fun getTopTechCrunch(): Call<ResponseArticles>

    @Headers("x-api-key:975b651e722640579883da60120b54fc")
    @GET("v2/everything?domains=wsj.com&apiKey=975b651e722640579883da60120b54fc")
    fun getWSJ(): Call<ResponseArticles>

}