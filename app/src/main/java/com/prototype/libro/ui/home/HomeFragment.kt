package com.prototype.libro.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.prototype.libro.R
import com.prototype.libro.databinding.FragmentHomeBinding
import com.prototype.model.AnimalData

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    val viewModel: HomeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        val recyclerView = binding.root.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter =
            HomeAdapter(mutableListOf(AnimalData("cat", "lion", "40", "domestic", "fjkadsjfkl") ,
                AnimalData("dog", "lion", "40", "domestic", "fjkadsjfkl")))
        return binding.root
    }
}