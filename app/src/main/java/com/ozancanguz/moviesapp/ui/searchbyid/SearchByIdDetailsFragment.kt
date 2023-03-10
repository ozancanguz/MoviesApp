package com.ozancanguz.moviesapp.ui.searchbyid

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.data.db.FavoritesEntity
import com.ozancanguz.moviesapp.databinding.FragmentSearchByIdDetailsBinding
import com.ozancanguz.moviesapp.utils.Util.Companion.loadImage
import com.ozancanguz.moviesapp.viewmodels.SearchByIdViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchByIdDetailsFragment : Fragment() {

    private var _binding: FragmentSearchByIdDetailsBinding? = null

    private val binding get() = _binding!!

    private val args:SearchByIdDetailsFragmentArgs by navArgs()

    private val searchByIdViewModel:SearchByIdViewModel by viewModels()



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

    fun saveToFavorites(item: MenuItem){
        var favoritesEntity= FavoritesEntity(0,args.currentid)
        searchByIdViewModel.insertFavoriteProduct(favoritesEntity)
        changeMenuItemColor(item,R.color.purple_200)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.savetofavmenu){
            saveToFavorites(item)
            Toast.makeText(requireContext(),"Save to favorites", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun changeMenuItemColor(item: MenuItem, color: Int) {
        item.icon?.setTint(ContextCompat.getColor(requireContext(),color))
    }


    // create fav menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.fav_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }





    private fun updateUi() {
        var currentFilmId=args.currentid
        binding.Rating.text="Imdb Puan: " +currentFilmId.imdbRating
        binding.Director.text="Y??netmen: " +currentFilmId.director
        binding.actors.text="Akt??rler: " +currentFilmId.actors
        binding.idimageview.loadImage(currentFilmId.poster)
        binding.plotbtn.setOnClickListener {

            val action=SearchByIdDetailsFragmentDirections.actionSearchByIdDetailsFragmentToPlotFragment(currentFilmId)
            findNavController().navigate(action)

        }
    }


}