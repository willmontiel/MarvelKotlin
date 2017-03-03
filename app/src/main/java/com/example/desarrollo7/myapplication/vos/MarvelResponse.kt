package com.example.desarrollo7.myapplication.vos

import com.example.desarrollo7.myapplication.models.Character

/**
 * Created by desarrollo7 on 2/03/17.
 */
class MarvelResponse(var data: Data) {
    class Data(var results: List<Character>)
}
