package com.example.desarrollo7.myapplication.holders

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.desarrollo7.myapplication.controllers.MainController
import com.example.desarrollo7.myapplication.databinding.CardviewLayoutBinding
import com.example.desarrollo7.myapplication.models.Character
import com.example.desarrollo7.myapplication.rest.api.JsonKeys
import org.json.JSONException

/**
 * Created by desarrollo7 on 2/03/17.
 */
class CharactersHolder(var binding: CardviewLayoutBinding, var context: Context, val controller: MainController) : RecyclerView.ViewHolder(binding.root) {
    lateinit var character: Character

    fun setSummaryData() {
        var comicsAvailable: Int = 0
        var seriesAvailable: Int = 0
        if (character.comics != null)
            comicsAvailable = character.comics!!.available

        if (character.series != null)
            seriesAvailable = character.series!!.available

        binding.character = character
        binding.controller = controller

        binding.comicsSeries.text = "Este personaje participa en " + comicsAvailable + " comics y " + seriesAvailable + " series."
        setThumbnail(getUrlThumbnail(JsonKeys.CHARACTER_THUMBNAIL_RATIO_PORTRAIT_MEDIUM))
    }

    fun getUrlThumbnail(size: String): String {
        val thumbnailData = character.thumbnail
        var url = ""
        if(thumbnailData != null)
            url = thumbnailData.getThumb(size)

        return url
    }

    fun setThumbnail(url: String) {
        Glide.with(this.context).load(url)
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.thumbnail)
    }
}