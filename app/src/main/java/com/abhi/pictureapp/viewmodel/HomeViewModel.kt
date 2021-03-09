package com.abhi.pictureapp.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.abhi.pictureapp.R
import com.abhi.pictureapp.data.model.ImageDataModel
import com.google.gson.Gson
import kotlinx.coroutines.launch

// viewmodel for loading data from json

class HomeViewModel(app: Application) : AndroidViewModel(app) {

    private val context = getApplication<Application>().applicationContext

    var imageList = MutableLiveData<ArrayList<ImageDataModel>>()
    var isLoading = MutableLiveData<Boolean>()
    var errorMessage = MutableLiveData<String>()

    fun fetchImageListFromJson() {
        isLoading.value = true
        viewModelScope.launch {
            try {
                val jsonText = context.resources.openRawResource(R.raw.data)
                    .bufferedReader().use { it.readText() }

                val imageArray: Array<ImageDataModel> =
                    Gson().fromJson(jsonText, Array<ImageDataModel>::class.java)

                imageList.value = imageArray.toCollection(ArrayList())
                isLoading.value = false
            } catch (e: Exception) {
                isLoading.value = false
                errorMessage.value = e.localizedMessage
            }
        }
    }
}