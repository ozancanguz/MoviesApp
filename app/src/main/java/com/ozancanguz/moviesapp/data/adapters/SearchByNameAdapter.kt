package com.ozancanguz.moviesapp.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.data.model.searchbyname.SearchByName
import com.ozancanguz.moviesapp.data.model.searchbyname.SearchNameResult
import com.ozancanguz.moviesapp.ui.searchbyname.SearchByNameFragmentDirections
import com.ozancanguz.moviesapp.utils.Util.Companion.loadImage
import kotlinx.android.synthetic.main.searchname_rv.view.*

class SearchByNameAdapter:RecyclerView.Adapter<SearchByNameAdapter.SearchViewHolder>() {

    var searchbynameList= emptyList<SearchNameResult>()

    fun setData(newData:SearchByName){
        this.searchbynameList=newData.result
         notifyDataSetChanged()
    }


    class SearchViewHolder(view: View):RecyclerView.ViewHolder(view){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.searchname_rv,parent,false)
        return SearchViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val currentMovie=searchbynameList[position]
        holder.itemView.SearchNameTitle.text=currentMovie.title
        holder.itemView.SearchNameYear.text=currentMovie.year.toString()

        // image loading with glide

        holder.itemView.SearchNameimageView.loadImage(currentMovie.poster)

        holder.itemView.setOnClickListener {
            val action=SearchByNameFragmentDirections.actionSearchByNameFragmentToSearchByNameDetailsFragment(currentMovie)

            holder.itemView.findNavController().navigate(action)


        }



    }

    override fun getItemCount(): Int {
       return searchbynameList.size
    }
}