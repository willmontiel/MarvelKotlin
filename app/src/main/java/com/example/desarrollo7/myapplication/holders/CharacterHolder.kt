package com.example.desarrollo7.myapplication.holders

import android.content.Context
import android.support.v7.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.desarrollo7.myapplication.controllers.CharacterController
import com.example.desarrollo7.myapplication.databinding.FragmentCharacterDetailBinding
import com.example.desarrollo7.myapplication.models.Character
import com.example.desarrollo7.myapplication.rest.api.JsonKeys

/**
 * Created by desarrollo7 on 3/03/17.
 */
class CharacterHolder(var binding: FragmentCharacterDetailBinding, var context: Context, val controller: CharacterController) : RecyclerView.ViewHolder(binding.root) {
    lateinit var character: Character

    fun setSummaryData() {
        binding.character = character
        binding.controller = controller

        setImage(getImageUrl(JsonKeys.CHARACTER_THUMBNAIL_RATIO_LANDSCAPE_XLARGE))
    }

    fun getImageUrl(size: String): String {
        val thumbnailData = character.thumbnail
        var url = ""
        if(thumbnailData != null)
            url = thumbnailData.getThumb(size)
        return url
    }

    fun setImage(url: String) {
        Glide.with(this.context).load(url)
                .thumbnail(0.5f)
                .crossFade()
                //.fitCenter()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.thumbnail)
    }
}