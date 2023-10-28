package com.example.zoobereketmarket.ui.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.zoobereketmarket.R
import com.example.zoobereketmarket.databinding.FragmentLoginBinding

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var binding: FragmentLoginBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

    }
}