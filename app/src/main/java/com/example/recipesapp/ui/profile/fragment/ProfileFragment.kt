// ProfileFragment.kt

package com.example.recipesapp.ui.profile.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.recipesapp.R
import com.example.recipesapp.databinding.FragmentProfileBinding
import com.example.recipesapp.ui.profile.adapter.MyRecipesAdapter
import com.example.recipesapp.ui.profile.viewmodel.ProfileViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipesAdapter: MyRecipesAdapter
    private val viewModel by lazy {
        ViewModelProvider(requireActivity()).get(ProfileViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        recyclerView = binding.recyclerViewProfile

        recipesAdapter = MyRecipesAdapter(emptyList(), requireContext()) { selectedRecipe ->
            val bundle = Bundle()
            bundle.putString("recipeId", selectedRecipe.id.toString())
            findNavController().navigate(R.id.myRecipeDetail, bundle)
        }

        recyclerView.adapter = recipesAdapter

        viewModel.myRecipesList.observe(viewLifecycleOwner) { recipesList ->
            recipesAdapter.setData(recipesList)
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_newRecipeFragment)
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchMyRecipeData(requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}