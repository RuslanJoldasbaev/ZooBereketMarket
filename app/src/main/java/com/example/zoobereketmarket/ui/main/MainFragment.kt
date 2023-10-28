package com.example.zoobereketmarket.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.zoobereketmarket.R
import com.example.zoobereketmarket.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

    private lateinit var binding: FragmentMainBinding
    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMainBinding.bind(view)

        val navHostFragment =
            childFragmentManager.findFragmentById(R.id.fragment_container_child) as NavHostFragment

        navController = navHostFragment.findNavController()

        binding.bottomNavigation.setupWithNavController(navController)
    }
}