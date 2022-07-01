package com.adl.newsapp.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class headModel(
    val teksTitle:String,
    val link:String
): Parcelable

@Parcelize
data class everyModel(
    val teksTitle:String,
    val link:String
): Parcelable
