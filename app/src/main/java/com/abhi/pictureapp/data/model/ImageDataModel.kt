package com.abhi.pictureapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

// json model

@Parcelize
data class ImageDataModel (

    @field:SerializedName("copyright")
    var copyright: String? = null,

    @field:SerializedName("date")
    var date: String? = null,

    @field:SerializedName("explanation")
    var explanation: String? = null,

    @field:SerializedName("hdurl")
    var hdurl: String? = null,

    @field:SerializedName("media_type")
    val media_type: String? = null,

    @field:SerializedName("service_version")
    var service_version: String? = null,

    @field:SerializedName("title")
    var title: String? = null,

    @field:SerializedName("url")
    var url: String? = null
) : Parcelable