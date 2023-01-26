package com.ozancanguz.moviesapp.ui.searchbyid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.data.adapters.SearchByIdAdapter
import com.ozancanguz.moviesapp.data.db.FavoritesEntity
import com.ozancanguz.moviesapp.data.model.searchbyid.SearchByIdModel
import com.ozancanguz.moviesapp.databinding.FragmentSearchByIdBinding
import com.ozancanguz.moviesapp.viewmodels.SearchByIdViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchByIdFragment : Fragment() {

    private var _binding: FragmentSearchByIdBinding? = null
    private val binding get() = _binding!!

    private val searchByIdViewModel:SearchByIdViewModel by viewModels()
    private val adapter=SearchByIdAdapter()




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchByIdBinding.inflate(inflater, container, false)
        val view = binding.root

        // observe data and update ui function
        observeLiveData()

        // setup rv function
        setupRv()



        return view
    }

    private fun setupRv() {
        binding.searchidRv.layoutManager=LinearLayoutManager(requireContext())
        binding.searchidRv.adapter=adapter
    }

    private fun observeLiveData() {
        binding.idsearchbtn.setOnClickListener {
            binding.idpb.visibility=View.VISIBLE
            val movieId=binding.idfilmEditText.text.toString()
            searchByIdViewModel.searchById(movieId)
            searchByIdViewModel.searchByIdList.observe(viewLifecycleOwner, Observer {
                adapter.setData(it)
                binding.idpb.visibility=View.INVISIBLE

            })
        } }



}