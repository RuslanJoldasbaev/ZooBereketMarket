package com.example.zoobereketmarket.ui.favorite

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zoobereketmarket.R
import com.example.zoobereketmarket.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment(R.layout.fragment_favorite) {
    private lateinit var binding: FragmentFavoriteBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavoriteBinding.bind(view)

    }
}