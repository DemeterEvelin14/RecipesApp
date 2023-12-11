package com.example.recipesapp.ui.profile.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipesapp.databinding.RecipeListItemBinding
import com.example.recipesapp.repository.recipe.model.MyRecipeModel

class MyRecipesAdapter(
    private var myRecipesList: List<MyRecipeModel>,
    private val context: Context?,
    private val onItemClickListener: ((MyRecipeModel) -> Unit)? = null
) : RecyclerView.Adapter<MyRecipesAdapter.RecipeItemViewHolder>() {

    inner class RecipeItemViewHolder(private val binding: RecipeListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val recipeName = binding.recipeName

        init {
            binding.root.setOnClickListener {
                val position = this.absoluteAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClickListener?.invoke(myRecipesList[position])
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
        val currentRecipe = myRecipesList[position]
        holder.recipeName.text = currentRecipe.name
        holder.itemView.setOnClickListener {
            onItemClickListener?.let { it1 -> it1(currentRecipe) }
        }
    }

    override fun getItemCount(): Int = myRecipesList.size

    fun setData(newList: List<MyRecipeModel>) {
        myRecipesList = newList
        notifyDataSetChanged()
    }
}