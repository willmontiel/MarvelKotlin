package com.example.desarrollo7.myapplication.adapters

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.desarrollo7.myapplication.R
import com.example.desarrollo7.myapplication.controllers.MainController
import com.example.desarrollo7.myapplication.databinding.CardviewLayoutBinding
import com.example.desarrollo7.myapplication.holders.CharactersHolder
import com.example.desarrollo7.myapplication.models.Character

/**
 * Created by desarrollo7 on 2/03/17.
 */
class CharactersAdapter// Provide a suitable constructor (depends on the kind of dataset)
(private val items: List<Character>, protected var context: Context, val controller: MainController) : RecyclerView.Adapter<CharactersHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersHolder {
        val binding: CardviewLayoutBinding = DataBindingUtil.inflate(inflater, R.layout.cardview_layout, parent, false)
        return CharactersHolder(binding, context, controller)
    }

    override fun onBindViewHolder(holder: CharactersHolder, position: Int) {
        val character = this.items[position]
        holder.character = character
        holder.setSummaryData()
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount(): Int {
        return this.items.size
    }


}