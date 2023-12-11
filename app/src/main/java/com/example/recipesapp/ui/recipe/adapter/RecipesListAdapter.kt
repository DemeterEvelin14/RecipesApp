package com.example.recipesapp.ui.recipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipesapp.R
import com.example.recipesapp.databinding.RecipeListItemBinding
import com.example.recipesapp.repository.recipe.model.RecipeModel

class RecipesListAdapter(
    private var recipesList: List<RecipeModel>,
    private val context: Context?,
    private var onItemClickListener: (RecipeModel) -> Unit
) : RecyclerView.Adapter<RecipesListAdapter.RecipeItemViewHolder>() {

    inner class RecipeItemViewHolder(binding: RecipeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val recipeName = binding.recipeName
        val recipeImage = binding.recipeImage
        val recipeRating = binding.ratingNumber
                                                                    
        init {
            binding.root.setOnClickListener {
                val position = this.absoluteAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener(recipesList[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeItemViewHolder {
        val binding = RecipeListItemBinding
            .inflate(LayoutInflater.from(context), parent, false)
        return RecipeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeItemViewHolder, position: Int) {
        val currentRecipe = recipesList[position]
        holder.recipeName.text = currentRecipe.name
        Glide.with(context!!)
            .load(currentRecipe.thumbnail_url)
            .placeholder(R.drawable.ic_recipes)
            .into(holder.recipeImage)
        holder.recipeRating.text = currentRecipe.user_ratings?.score.toString()
    }

    override fun getItemCount(): Int = recipesList.size

    fun setData(newList: List<RecipeModel>) {
        recipesList = newList
        notifyDataSetChanged()
    }
}