package com.example.seekgame.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.seekgame.holders.GameHolder
import com.example.seekgame.R
import com.example.seekgame.entities.Game
import com.example.seekgame.fragments.GameFragment
import com.example.seekgame.fragments.LoginFragmentDirections
import com.example.seekgame.fragments.SearchFragmentDirections

class GameListAdapter(private val listGames: MutableList<Game>, val context: Context, val onItemClick : (Int) -> Unit): RecyclerView.Adapter<GameHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_game,parent,false)
        return GameHolder(view)
    }
    override fun getItemCount(): Int = listGames.size
    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.setName(listGames[position].name)

        Glide
            .with(context)
            .load(listGames[position].background_image)
            .centerCrop()
            .into(holder.getImageView())

        holder.getCardLayout().setOnClickListener  () {
            onItemClick(position)
        }
    }
}