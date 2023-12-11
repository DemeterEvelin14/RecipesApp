// MyRecipeDetailsFragment.kt

package com.example.recipesapp.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.recipesapp.databinding.FragmentMyRecipesDetailBinding

class MyRecipeDetailsFragment : Fragment() {

    private var _binding: FragmentMyRecipesDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyRecipesDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recipeId = arguments?.getString("recipeId")

        if (recipeId != null) {
            binding.recipeDetailsTextView.text = "Details for Recipe ID: $recipeId"          }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}