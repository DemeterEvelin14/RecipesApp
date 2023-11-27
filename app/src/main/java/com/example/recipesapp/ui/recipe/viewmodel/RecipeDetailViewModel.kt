package com.example.recipesapp.ui.recipe.viewmodel

import androidx.lifecycle.ViewModel
import com.example.recipesapp.repository.recipe.model.RecipeModel

class RecipeDetailViewModel : ViewModel() {
    private var selectedRecipe: RecipeModel? = null

    fun setSelectedRecipe(recipe: RecipeModel) {
        selectedRecipe = recipe
    }

    fun getSelectedRecipe(): RecipeModel? {
        return selectedRecipe
    }
}