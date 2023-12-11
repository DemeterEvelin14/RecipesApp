package com.example.recipesapp.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.recipesapp.databinding.FragmentMyRecipesDetailBinding
import com.example.recipesapp.ui.profile.viewmodel.ProfileViewModel

class MyRecipeDetailsFragment : Fragment() {

    private var _binding: FragmentMyRecipesDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyRecipesDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedRecipe = viewModel.getSelectedRecipe()
        selectedRecipe?.let { recipe ->
            binding.recipeDetailName.text = recipe.name
            binding.recipeDetailDescription.text = recipe.description
        }

    }
}