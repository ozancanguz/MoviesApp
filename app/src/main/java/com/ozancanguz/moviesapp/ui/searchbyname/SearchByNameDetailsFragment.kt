package com.ozancanguz.moviesapp.ui.searchbyname

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.databinding.FragmentSearchByNameDetailsBinding
import com.ozancanguz.moviesapp.utils.Util.Companion.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchByNameDetailsFragment : Fragment() {

    private var _binding: FragmentSearchByNameDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:SearchByNameDetailsFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchByNameDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        updateUi()

        return view


    }

    private fun updateUi() {
        val currenSearchName=args.currentNameDetails
        binding.imageView.loadImage(currenSearchName.poster)
        binding.titletv.text=currenSearchName.title
        binding.typetv.text="Tür: "+currenSearchName.type
        binding.yearTv.text="Yıl: "+currenSearchName.year
        binding.imdbIdtv.text="Imdb Id: "+currenSearchName.imdbID
    }


}