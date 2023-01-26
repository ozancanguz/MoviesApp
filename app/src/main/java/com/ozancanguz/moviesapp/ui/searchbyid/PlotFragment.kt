package com.ozancanguz.moviesapp.ui.searchbyid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.databinding.FragmentPlotBinding
import com.ozancanguz.moviesapp.utils.Util.Companion.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlotFragment : Fragment() {

     private var _binding: FragmentPlotBinding? = null

    private val binding get() = _binding!!

    private val args:PlotFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          _binding = FragmentPlotBinding.inflate(inflater, container, false)
        val view = binding.root

       updateUi()



        return view
    }

    private fun updateUi() {
        var currentPlot=args.currentPlot
        binding.plotimage.loadImage(currentPlot.poster)
        binding.plottv.text=currentPlot.plot

    }


}