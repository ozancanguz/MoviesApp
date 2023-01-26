package com.ozancanguz.moviesapp.ui.favoriteFilms

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.data.adapters.FavoritesAdapter
import com.ozancanguz.moviesapp.databinding.FragmentFavoriteFilmsBinding
import com.ozancanguz.moviesapp.viewmodels.SearchByIdViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFilmsFragment : Fragment() {

    private var _binding: FragmentFavoriteFilmsBinding? = null

    private val binding get() = _binding!!

    private val favoritesAdapter=FavoritesAdapter()

    private val searchByIdViewModel:SearchByIdViewModel by viewModels()






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          _binding = FragmentFavoriteFilmsBinding.inflate(inflater, container, false)
        val view = binding.root

        // setting up rv
        setupRv()

        observeLiveData()


        return view
    }

    private fun setupRv() {
        binding.favrecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.favrecyclerView.adapter=favoritesAdapter
    }

    private fun observeLiveData() {
        searchByIdViewModel.favProductList.observe(viewLifecycleOwner, Observer {
            favoritesAdapter.setData(it)
        })

    }


}