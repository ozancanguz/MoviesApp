package com.ozancanguz.moviesapp.ui.searchbyname.plot

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.databinding.FragmentSearchByNamePlotBinding
import com.ozancanguz.moviesapp.utils.Util.Companion.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchByNamePlot : Fragment() {

    private var _binding: FragmentSearchByNamePlotBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchByNamePlotBinding.inflate(inflater, container, false)
        val view = binding.root



        return view

    }



}