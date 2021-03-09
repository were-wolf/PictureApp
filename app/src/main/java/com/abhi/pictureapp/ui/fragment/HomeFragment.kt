package com.abhi.pictureapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.abhi.pictureapp.R
import com.abhi.pictureapp.data.model.ImageDataListModel
import com.abhi.pictureapp.data.model.ImageDataModel
import com.abhi.pictureapp.databinding.FragmentHomeBinding
import com.abhi.pictureapp.ui.adapter.ImageAdapter
import com.abhi.pictureapp.viewmodel.HomeViewModel
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

// home page - shows images in gridview

class HomeFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var bindingFragment: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private lateinit var imageAdapter: ImageAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        navController = findNavController()
        bindingFragment.lifecycleOwner = this
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        bindingFragment.viewModel = viewModel
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchImageListFromJson()
        observeData()
    }

    private fun observeData() {
        viewModel.imageList.observe(viewLifecycleOwner, Observer {
            if (!it.isNullOrEmpty()) {
                sortByDate(it)
            }
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer {

        })

        viewModel.errorMessage.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun sortByDate(array: ArrayList<ImageDataModel>?) {
        array!!.sortByDescending { it.date!!.toDate() }
        setImageAdapter(array)
    }

    private fun String.toDate(): Date{
        return SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(this)
    }

    private fun setImageAdapter(imageList: ArrayList<ImageDataModel>) {
        imageAdapter = ImageAdapter(imageList) {
            navigateToDetailPage(it.toString(), imageList)
        }
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        bindingFragment.rvImages.layoutManager = staggeredGridLayoutManager
        bindingFragment.rvImages.adapter = imageAdapter
    }

    private fun navigateToDetailPage(
        position: String,
        imageList: ArrayList<ImageDataModel>
    ) {
        val imageDataListModel = ImageDataListModel(imageList)
        imageDataListModel.imageDataListModel =  imageList
        val action =
            HomeFragmentDirections.actionHomeFragmentToImageDetailFragment(position, imageDataListModel)
        navController.navigate(action)
    }
}