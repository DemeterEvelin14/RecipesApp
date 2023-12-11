package com.example.recipesapp.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.recipesapp.R
import com.example.recipesapp.databinding.FragmentNewRecipeBinding
import com.example.recipesapp.repository.recipe.RecipeRepository
import com.example.recipesapp.repository.recipe.model.MyRecipeModel
import com.example.recipesapp.ui.profile.viewmodel.ProfileViewModel

class NewRecipeFragment : Fragment() {
    private lateinit var profileViewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentNewRecipeBinding.inflate(inflater, container, false)
        profileViewModel = ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)

        binding.addButton.setOnClickListener {
            val name = binding.recipeNameEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()

            val newRecipe = MyRecipeModel(id = 1, name = name, description = description)

            RecipeRepository.insertRecipe(newRecipe)

            profileViewModel.fetchMyRecipeData(requireContext())

            findNavController().navigateUp()
        }

        return binding.root
    }
}