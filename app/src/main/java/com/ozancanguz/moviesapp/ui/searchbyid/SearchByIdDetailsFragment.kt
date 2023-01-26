package com.ozancanguz.moviesapp.ui.searchbyid

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.databinding.FragmentSearchByIdDetailsBinding
import com.ozancanguz.moviesapp.utils.Util.Companion.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchByIdDetailsFragment : Fragment() {

    private var _binding: FragmentSearchByIdDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:SearchByIdDetailsFragmentArgs by navArgs()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSearchByIdDetailsBinding.inflate(inflater, container, false)
        val view = binding.root


        updateUi()

        setHasOptionsMenu(true)

        return view

    }

    // create fav menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fav_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    // fav menu onclick
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.savetofavmenu){
          Log.d("detail-screen","Fav save")
        }

        return super.onOptionsItemSelected(item)
    }

    private fun updateUi() {
        var currentFilmId=args.currentid
        binding.Rating.text="Imdb Puan: " +currentFilmId.imdbRating
        binding.Director.text="Yönetmen: " +currentFilmId.director
        binding.actors.text="Aktörler: " +currentFilmId.actors
        binding.idimageview.loadImage(currentFilmId.poster)
        binding.plotbtn.setOnClickListener {

            val action=SearchByIdDetailsFragmentDirections.actionSearchByIdDetailsFragmentToPlotFragment(currentFilmId)
            findNavController().navigate(action)

        }
    }


}