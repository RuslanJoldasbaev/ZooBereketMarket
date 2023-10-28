package com.example.zoobereketmarket.ui.categoriy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zoobereketmarket.R
import com.example.zoobereketmarket.databinding.FragmentAnimalsCategoriyBinding

class CategoriyAnimalsFragment : Fragment(R.layout.fragment_animals_categoriy) {
    private lateinit var binding: FragmentAnimalsCategoriyBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAnimalsCategoriyBinding.bind(view)

    }
}