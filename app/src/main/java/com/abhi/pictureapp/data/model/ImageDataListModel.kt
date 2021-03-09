package com.abhi.pictureapp.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

// model used for array passing as arguments

@Parcelize
class ImageDataListModel (
    @field:SerializedName("imageDataListModel")
    var imageDataListModel: ArrayList<ImageDataModel>? = null
) : Parcelable