package com.ozancanguz.moviesapp.ui.favoriteFilms

import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
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

        // update ui
        observeLiveData()

        setHasOptionsMenu(true)

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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.deleteallmenu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId ==R.id.delete_all_menu){


            val builder = AlertDialog.Builder(requireContext())

            builder.setMessage("Do you want to delete all favorites ?")

            builder.setTitle("Delete all favorites !")

            builder.setCancelable(false)

            builder.setPositiveButton("Yes",
                DialogInterface.OnClickListener { dialog: DialogInterface?, which: Int ->
                    searchByIdViewModel.deleteAll()
                    Toast.makeText(requireContext(),"All favorites are deleted",Toast.LENGTH_LONG).show()
                    binding.notfavimg.visibility=View.VISIBLE
                })

            builder.setNegativeButton("No",
                DialogInterface.OnClickListener { dialog: DialogInterface, which: Int ->

                    dialog.cancel()
                } )

            val alertDialog = builder.create()
            alertDialog.show()




        }

        return super.onOptionsItemSelected(item)
    }


}