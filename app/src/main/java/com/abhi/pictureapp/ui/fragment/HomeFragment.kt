package com.abhi.pictureapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.abhi.pictureapp.R
import com.abhi.pictureapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var navController: NavController
    private lateinit var bindingFragment: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        navController = findNavController()
        bindingFragment.lifecycleOwner = this
        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}