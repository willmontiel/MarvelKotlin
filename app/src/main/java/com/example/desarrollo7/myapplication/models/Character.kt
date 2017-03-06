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
                var series: CharacterSeries? = null,
                var events: CharacterEvents? = null,
                var stories: CharacterStories? = null
                ){

    class CharacterThumbnail(val path:String, val extension:String){
        fun getThumb(size:String): String{
            return "$path/$size.$extension"
        }
    }

    class CharacterComics(val available: Int = 0, val items: MutableList<Comic>) {
        class Comic(val name: String = "")
    }

    class CharacterSeries(val available: Int = 0, items: MutableList<Serie>) {
        class Serie(val name: String = "")
    }

    class CharacterEvents(val available: Int = 0, val items: MutableList<Event>) {
        class Event(val name: String = "")
    }

    class CharacterStories(val available: Int = 0, val items: MutableList<Story>) {
        class Story(val name: String = "")
    }
}