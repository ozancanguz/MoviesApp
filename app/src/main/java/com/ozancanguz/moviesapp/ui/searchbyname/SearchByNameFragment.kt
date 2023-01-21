package com.ozancanguz.moviesapp.ui.searchbyname

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.databinding.FragmentSearchByNameBinding
import com.ozancanguz.moviesapp.viewmodels.SearchByNameViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchByNameFragment : Fragment() {

    private var _binding: FragmentSearchByNameBinding? = null

    private val binding get() = _binding!!

    private val searchByNameViewModel:SearchByNameViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchByNameBinding.inflate(inflater, container, false)
        val view = binding.root

        // observe live data and update ui
        observeLiveData()


        return view
    }

    private fun observeLiveData() {

    }


}