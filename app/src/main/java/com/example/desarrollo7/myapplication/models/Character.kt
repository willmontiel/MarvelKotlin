package com.example.desarrollo7.myapplication.models

import com.google.gson.JsonObject


/**
 * Created by desarrollo7 on 2/03/17.
 */

class Character(val id: Int = 0,
                val name: String = "",
                val description: String = "",
                val thumbnail: CharacterThumbnail? = null,
                var comics: CharacterComics? = null,
                var series: CharacterSeries? = null
                /*
                var series: List<JSONObject> = listOf(),
                var totalStories: Int = 0,
                var stories: List<JSONObject> = listOf(),
                var events: List<JSONObject> = listOf(),
                var totalEvents: Int = 0,
                var urls: List<JSONObject> = listOf()
                */
                ){

    class CharacterThumbnail(val path:String, val extension:String){
        fun getThumb(size:String): String{
            return "$path/$size.$extension"
        }
    }

    class CharacterComics(val available: Int = 0)
    class CharacterSeries(val available: Int = 0)
}