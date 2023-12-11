package com.example.recipesapp.repository.recipe

import android.content.Context
import android.util.Log
import com.example.recipesapp.repository.recipe.model.MyRecipeModel
import com.example.recipesapp.repository.recipe.model.RecipeModel
import com.example.recipesapp.repository.recipe.model.RecipesDTO
import com.example.recipesapp.repository.recipe.model.toModelList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

object RecipeRepository {

    private val TAG: String? = RecipeRepository::class.java.canonicalName
    private var recipeList: List<RecipeModel> = emptyList()
    private var myRecipeList: ArrayList<MyRecipeModel> = ArrayList()

    fun getRecipes(context: Context): List<RecipeModel> {
        lateinit var jsonString: String
        try {
            jsonString =
                context.assets.open("recipes.json")
                    .bufferedReader()
                    .use {
                        it.readText()
                    }
        } catch (ioException: IOException) {
            Log.e(TAG, ioException.message.toString())
        }
        val recipesResponse: RecipesDTO =
            Gson().fromJson(jsonString, object : TypeToken<RecipesDTO>() {}.type)
        return recipesResponse.results.toModelList()
    }

    fun insertRecipe(recipeModel: MyRecipeModel): Boolean {
        return myRecipeList.add(recipeModel)
    }

    fun deleteRecipe(recipeModel: MyRecipeModel): Boolean {
        return myRecipeList.remove(recipeModel)
    }

    fun getMyRecipes(context: Context) = myRecipeList
}