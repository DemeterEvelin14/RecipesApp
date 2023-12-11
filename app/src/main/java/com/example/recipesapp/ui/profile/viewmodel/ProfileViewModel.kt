package com.example.recipesapp.ui.profile.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipesapp.repository.recipe.RecipeRepository
import com.example.recipesapp.repository.recipe.model.MyRecipeModel

class ProfileViewModel : ViewModel() {
    private val repository = RecipeRepository
    val myRecipesList: MutableLiveData<ArrayList<MyRecipeModel>> = MutableLiveData()
    private var selectedRecipe: MyRecipeModel? = null

    fun fetchMyRecipeData(context: Context) {
        myRecipesList.value = repository.getMyRecipes(context)
    }

    fun setSelectedRecipe(recipe: MyRecipeModel) {
        selectedRecipe = recipe
    }

    fun getSelectedRecipe(): MyRecipeModel? {
        return selectedRecipe
    }
}