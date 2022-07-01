package com.adl.newsapp.services

import com.adl.newsapp.model.ResponseArticles
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*

interface InterfaceUser {
//    @Headers("x-api-key:975b651e722640579883da60120b54fc")
//    @GET("api/user_table/all")
//    fun getUserLogin(@Query("filter")filters:String, @Query("field")field:String): Call<ResponseLogin>

    @Headers("x-api-key:975b651e722640579883da60120b54fc")
    @GET("v2/everything?q=apple&from=2022-06-30&to=2022-06-30&sortBy=popularity")
    fun getArticle(): Call<ResponseArticles>

//    @Headers("x-api-key:975b651e722640579883da60120b54fc")
//    @GET("api/absen/all")
//    fun getDataAbsen(@Query("limit")limit:String, @Query("sort_order")sort_order:String): Call<ResponseGetAbsen>
//
//
//    @Multipart
//    @Headers("X-Api-Key:975b651e722640579883da60120b54fc")
//    @POST("api/absen/add")
//    fun addDataAndImage(@Part file: MultipartBody.Part, @Part("username") username: RequestBody,
//                        @Part("tanggal_masuk")tanggal_masuk: RequestBody, @Part("tanggal_keluar")tanggal_keluar: RequestBody,
//                        @Part("lokasi_GPS")lokasi_GPS: RequestBody
//    ): Call<ResponseAddData>
//
//    @Multipart
//    @Headers("X-Api-Key:975b651e722640579883da60120b54fc")
//    @POST("api/absen/update")
//    fun updateDataAndImage(@Part("id") id: RequestBody, @Part file: MultipartBody.Part, @Part("username") username: RequestBody,
//                           @Part("tanggal_masuk")tanggal_masuk: RequestBody, @Part("tanggal_keluar")tanggal_keluar: RequestBody,
//                           @Part("lokasi_GPS")lokasi_GPS: RequestBody
//    ): Call<ResponseCheckOut>


}