package com.example.zoobereketmarket.ui.post

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zoobereketmarket.R
import com.example.zoobereketmarket.databinding.FragmentPostBinding

class PostFragment : Fragment(R.layout.fragment_post) {
    private lateinit var binding: FragmentPostBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentPostBinding.bind(view)

    }
}