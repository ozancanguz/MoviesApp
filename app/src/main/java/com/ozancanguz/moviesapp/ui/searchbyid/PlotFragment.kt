package com.ozancanguz.moviesapp.ui.searchbyid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.databinding.FragmentPlotBinding


class PlotFragment : Fragment() {

     private var _binding: FragmentPlotBinding? = null

    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          _binding = FragmentPlotBinding.inflate(inflater, container, false)
        val view = binding.root


        return view
    }


}