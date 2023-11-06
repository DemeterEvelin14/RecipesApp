package com.example.recipesapp.ui.recipe

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recipesapp.R
import com.example.recipesapp.activities.MainActivity
import com.example.recipesapp.repository.recipe.RecipeRepository

class RecipesFragment : Fragment() {
    companion object {
        private val TAG: String? = RecipesFragment::class.java.canonicalName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let {
            val recipes = RecipeRepository.getRecipes(it)
            Log.d(TAG, "Number of recipes = " + recipes.size)
        }
    }
}