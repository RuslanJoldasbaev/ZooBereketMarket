package com.example.zoobereketmarket.ui.animals

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zoobereketmarket.R
import com.example.zoobereketmarket.databinding.FragmentAnimalInfoBinding

class InfoAnimalsFragment : Fragment(R.layout.fragment_animal_info) {
    private lateinit var binding: FragmentAnimalInfoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAnimalInfoBinding.bind(view)

    }
}