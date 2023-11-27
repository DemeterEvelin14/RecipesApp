package com.example.recipesapp.ui.recipe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipesapp.R
import com.example.recipesapp.databinding.FragmentRecipesBinding
import com.example.recipesapp.ui.recipe.adapter.RecipesListAdapter
import com.example.recipesapp.ui.recipe.viewmodel.RecipeDetailViewModel
import com.example.recipesapp.ui.recipe.viewmodel.RecipeListViewModel

class RecipesFragment : Fragment() {
    private var _binding: FragmentRecipesBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipesAdapter: RecipesListAdapter

    companion object {
        private val TAG: String? = RecipesFragment::class.java.canonicalName
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerView
        val recipeDetailViewModel = ViewModelProvider(requireActivity()).get(RecipeDetailViewModel::class.java)

        recipesAdapter = RecipesListAdapter(ArrayList(), requireContext()) { recipe ->
            recipeDetailViewModel.setSelectedRecipe(recipe)
            //kijavitani -> id-t kuld at csak
            findNavController().navigate(R.id.action_recipesFragment_to_recipeDetailFragment)
        }

        initRecycleView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)

        context?.let {
            viewModel.fetchRecipeData(it)
        }

        viewModel.recipesList.observe(viewLifecycleOwner) { recipes ->
            recipesAdapter.setData(recipes)
        }
        
    }

    private fun initRecycleView() {
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = recipesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}