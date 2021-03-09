package com.abhi.pictureapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

// json model

@Parcelize
data class ImageDataModel (

    @field:SerializedName("copyright")
    val copyright: String? = null,

    @field:SerializedName("date")
    val date: String? = null,

    @field:SerializedName("explanation")
    val explanation: String? = null,

    @field:SerializedName("hdurl")
    val hdurl: String? = null,

    @field:SerializedName("media_type")
    val media_type: String? = null,

    @field:SerializedName("service_version")
    val service_version: String? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("url")
    val url: String? = null
) : Parcelable