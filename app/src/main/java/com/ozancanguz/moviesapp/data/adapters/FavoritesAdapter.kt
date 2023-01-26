package com.ozancanguz.moviesapp.data.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ozancanguz.moviesapp.R
import com.ozancanguz.moviesapp.data.db.FavoritesEntity
import com.ozancanguz.moviesapp.ui.favoriteFilms.FavoriteFilmsFragment
import com.ozancanguz.moviesapp.ui.favoriteFilms.FavoriteFilmsFragmentDirections
import com.ozancanguz.moviesapp.utils.Util.Companion.loadImage
import kotlinx.android.synthetic.main.searchbyid_fav_row_layout.view.*

class FavoritesAdapter:RecyclerView.Adapter<FavoritesAdapter.FavoriteViewHolder>() {
    class FavoriteViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }


    var favoritesList= emptyList<FavoritesEntity>()

    fun setData(newData:List<FavoritesEntity>){
        this.favoritesList=newData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val inflater= LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.searchbyid_fav_row_layout,parent,false)
        return FavoriteViewHolder(view)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
     val currentFavoritesEntity=favoritesList[position]
        holder.itemView.searchbyidfavimage.loadImage(currentFavoritesEntity.movies.poster)
        holder.itemView.searchbyidfavtitle.text=currentFavoritesEntity.movies.title
        holder.itemView.searchbyidfavyear.text=currentFavoritesEntity.movies.year

        holder.itemView.setOnClickListener {
            val action=FavoriteFilmsFragmentDirections.actionFavoriteFilmsFragmentToSearchByIdDetailsFragment(currentFavoritesEntity.movies)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
       return favoritesList.size
    }


}