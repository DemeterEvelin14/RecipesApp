package com.example.recipesapp.ui.recipe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.recipesapp.R
import com.example.recipesapp.databinding.FragmentRecipeDetailBinding
import com.example.recipesapp.ui.recipe.viewmodel.RecipeDetailViewModel

class RecipeDetailFragment : Fragment() {
    private var _binding: FragmentRecipeDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(RecipeDetailViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedRecipe = viewModel.getSelectedRecipe()
        selectedRecipe?.let { recipe ->
            binding.recipe = recipe
            context?.let {
                Glide.with(it)
                    .load(recipe.thumbnail_url)
                    .placeholder(R.drawable.ic_recipes)
                    .into(binding.recipeDetailImage)
            }
            binding.recipeDetailName.text = recipe.name
            binding.recipeDetailDescription.text = recipe.description
            binding.recipeDetailRatings.text = recipe.user_ratings?.score.toString()
            binding.recipeDetailPrice.text = recipe.price?.total.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}