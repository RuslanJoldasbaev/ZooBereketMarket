package com.example.zoobereketmarket.ui.splash

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.zoobereketmarket.R
import com.example.zoobereketmarket.databinding.FragmentSplashBinding
import kotlinx.coroutines.delay

class SplashFragment : Fragment(R.layout.fragment_splash) {
    private lateinit var binding: FragmentSplashBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentSplashBinding.bind(view)

        lifecycleScope.launchWhenResumed {
            delay(1000)
            findNavController().navigate(
                SplashFragmentDirections.actionSplashFragmentToMainFragment()
            )
        }
    }
}