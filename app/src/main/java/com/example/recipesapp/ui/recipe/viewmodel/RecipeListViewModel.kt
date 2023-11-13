package com.example.recipesapp.ui.recipe.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipesapp.repository.recipe.RecipeRepository
import com.example.recipesapp.repository.recipe.model.RecipeModel

class RecipeListViewModel : ViewModel() {
    private val repository = RecipeRepository

    val recipesList: MutableLiveData<List<RecipeModel>> = MutableLiveData()

    fun fetchRecipeData(context: Context) {
        recipesList.value = repository.getRecipes(context)
    }
}