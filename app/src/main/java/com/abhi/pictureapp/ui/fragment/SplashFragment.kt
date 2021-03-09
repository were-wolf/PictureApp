package com.abhi.pictureapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.abhi.pictureapp.R
import com.abhi.pictureapp.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// landing page

class SplashFragment : Fragment() {

    private lateinit var bindingFragment: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingFragment =
            DataBindingUtil.inflate(inflater, R.layout.fragment_splash, container, false)
        bindingFragment.lifecycleOwner = this

        return bindingFragment.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launch {
            delay(2000)
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }
}