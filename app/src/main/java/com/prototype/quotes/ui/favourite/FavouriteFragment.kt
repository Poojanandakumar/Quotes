package com.prototype.quotes.ui.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prototype.quotes.R
import com.prototype.quotes.databinding.FragmentFavouriteBinding
import com.prototype.quotes.databinding.FragmentHomeBinding
import com.prototype.quotes.ui.home.HomeAdapter
import com.prototype.quotes.ui.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavouriteFragment : Fragment() {
    private lateinit var binding: FragmentFavouriteBinding
    private val viewModel: FavouriteViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteBinding.inflate(layoutInflater, container, false)
        viewModel.getFavouriteQuotes()
        viewModel.data.observe(viewLifecycleOwner){
            val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerView)
            recyclerView.layoutManager = LinearLayoutManager(requireContext())
            binding.recyclerView.adapter =
                FavouriteQuotesAdapter(it,viewModel)
        }

        return binding.root
    }
}