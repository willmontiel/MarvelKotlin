package com.example.desarrollo7.myapplication.controllers

import com.example.desarrollo7.myapplication.CharacterActivity
import com.example.desarrollo7.myapplication.R
import com.example.desarrollo7.myapplication.fragments.CharacterDetailFragment

/**
 * Created by desarrollo7 on 3/03/17.
 */
class CharacterController(val characterActivity: CharacterActivity) {

}

fun CharacterActivity.initFragment() {
    val fragmentManager = fragmentManager
    val fragmentTransaction = fragmentManager.beginTransaction()
    val characterFragment = CharacterDetailFragment.newInstance(idChar, controller)
    fragmentTransaction.add(R.id.character_container_frame_layout, characterFragment)
    fragmentTransaction.commit()
}