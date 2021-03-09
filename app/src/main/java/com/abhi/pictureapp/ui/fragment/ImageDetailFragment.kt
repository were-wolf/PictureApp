package com.abhi.pictureapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.abhi.pictureapp.R
import com.abhi.pictureapp.data.model.ImageDataListModel
import com.abhi.pictureapp.data.model.ImageDataModel
import com.abhi.pictureapp.databinding.FragmentImageDetailBinding
import com.abhi.pictureapp.ui.adapter.ImageDetailAdapter

// image detail page - shows all details about image

class ImageDetailFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var bindingFragment: FragmentImageDetailBinding
    private val args by navArgs<ImageDetailFragmentArgs>()
    private var position: Int = 0
    private lateinit var imageDataListModel:ImageDataListModel
    private lateinit var imageList: ArrayList<ImageDataModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_image_detail, container, false)
        navController = findNavController()
        bindingFragment.lifecycleOwner = this
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        position = args.position.toInt()
        imageDataListModel = args.data
        imageList = imageDataListModel.imageDataListModel!!
        setImageAdapter()
    }

    private fun setImageAdapter() {
        bindingFragment.viewPager.adapter =
            activity?.let { ImageDetailAdapter(imageList, requireActivity()) }

        bindingFragment.viewPager.postDelayed(Runnable {
            bindingFragment.viewPager.currentItem = position
        }, 1000)
    }

}