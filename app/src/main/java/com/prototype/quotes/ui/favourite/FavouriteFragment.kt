package com.prototype.quotes.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prototype.quotes.R
import com.prototype.quotes.databinding.FragmentFavouriteBinding
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
            if(it.isNotEmpty()){
                val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerView)
                recyclerView.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerView.adapter =
                    FavouriteQuotesAdapter(it,viewModel)
            }else{
                binding.recyclerView.visibility = View.INVISIBLE
                binding.animationView.visibility = View.VISIBLE
            }
        }
        return binding.root
    }
}