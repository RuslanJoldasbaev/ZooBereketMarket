package com.example.zoobereketmarket.ui.animals

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.zoobereketmarket.R
import com.example.zoobereketmarket.databinding.FragmentAnimalsBinding
import com.example.zoobereketmarket.presentation.AnimalsViewModel
import com.example.zoobereketmarket.ui.adapters.CategoriesAdapter
import com.example.zoobereketmarket.utils.toast
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.viewModel

class AnimalsFragment : Fragment(R.layout.fragment_animals) {
    private lateinit var binding: FragmentAnimalsBinding
    private val adapter = CategoriesAdapter()
    private val viewModel by viewModel<AnimalsViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAnimalsBinding.bind(view)

        binding.animalsRecyclerView.adapter = adapter

        lifecycleScope.launchWhenResumed {
            viewModel.getCategories()
        }

        initObservers()
    }

    private fun initObservers() {
        viewModel.getCategoriesFlow.onEach {
            adapter.submitList(it.categories)
            toast("Success")
        }.launchIn(lifecycleScope)

        viewModel.messageFlow.onEach {
            toast("internetinizdi tekserin")
        }.launchIn(lifecycleScope)
    }
}