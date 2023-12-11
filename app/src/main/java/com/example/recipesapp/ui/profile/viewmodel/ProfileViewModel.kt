package com.example.recipesapp.ui.profile.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipesapp.repository.recipe.RecipeRepository
import com.example.recipesapp.repository.recipe.model.MyRecipeModel

class ProfileViewModel : ViewModel() {
    private val repository = RecipeRepository
    val myRecipesList: MutableLiveData<ArrayList<MyRecipeModel>> = MutableLiveData()

    fun fetchMyRecipeData(context: Context) {
        myRecipesList.value = repository.getMyRecipes(context)
    }
}