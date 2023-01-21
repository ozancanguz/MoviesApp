package com.ozancanguz.moviesapp.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.data.model.searchbyid.SearchByIdModel
import com.ozancanguz.moviesapp.utils.Util.Companion.loadImage
import kotlinx.android.synthetic.main.searchbyid_rv.view.*

class SearchByIdAdapter:RecyclerView.Adapter<SearchByIdAdapter.IdViewHolder>() {

    var searchbyidList= emptyList<com.ozancanguz.moviesapp.data.model.searchbyid.Result>()

    fun setData(newData:SearchByIdModel){
        this.searchbyidList= listOf(newData.result)
    }


    class IdViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IdViewHolder {
       val inflater=LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.searchbyid_rv,parent,false)
        return IdViewHolder(view)
    }

    override fun onBindViewHolder(holder: IdViewHolder, position: Int) {
       val currentByIdModel=searchbyidList[position]
        holder.itemView.searchbyidimageview.loadImage(currentByIdModel.poster)
        holder.itemView.searchbyidtitle.text=currentByIdModel.title
        holder.itemView.searchbyidyear.text=currentByIdModel.year


    }

    override fun getItemCount(): Int {
        return searchbyidList.size
    }
}