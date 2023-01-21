package com.ozancanguz.moviesapp.ui.searchbyname

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.data.adapters.SearchByNameAdapter
import com.ozancanguz.moviesapp.databinding.FragmentSearchByNameBinding
import com.ozancanguz.moviesapp.viewmodels.SearchByNameViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchByNameFragment : Fragment() {

    private var _binding: FragmentSearchByNameBinding? = null

    private val binding get() = _binding!!

    private val searchByNameViewModel:SearchByNameViewModel by viewModels()

    private val searchByNameAdapter=SearchByNameAdapter()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchByNameBinding.inflate(inflater, container, false)
        val view = binding.root

        // observe live data and update ui
        observeLiveData()

        // setup recyclerview
        setupRv()



        return view
    }



    private fun observeLiveData() {

        binding.searchbtn.setOnClickListener {
            binding.namePb.visibility=View.VISIBLE
            var searchText=binding.filmEditText.text.toString()
            searchByNameViewModel.searchFilmsByName(searchText)
            searchByNameViewModel.searchbyNameFilms.observe(viewLifecycleOwner, Observer {
                searchByNameAdapter.setData(it)
                binding.namePb.visibility=View.INVISIBLE
            })
        }

    }

    private fun setupRv() {
        binding.searchNameRv.layoutManager=LinearLayoutManager(requireContext())
        binding.searchNameRv.adapter=searchByNameAdapter

    }


}