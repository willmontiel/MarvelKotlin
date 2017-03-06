package com.example.desarrollo7.myapplication

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.desarrollo7.myapplication.controllers.CharacterController
import com.example.desarrollo7.myapplication.controllers.initFragment
import com.example.desarrollo7.myapplication.databinding.ActivityCharacterBinding
import com.example.desarrollo7.myapplication.rest.api.JsonKeys

class CharacterActivity : AppCompatActivity() {

    lateinit var binding: ActivityCharacterBinding
    lateinit var controller: CharacterController
    var idChar: String = "0"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_character)
        controller = CharacterController(this)

        val extras = intent.extras
        if (extras != null) {
            idChar = extras.getString(JsonKeys.CHARACTER_ID)
        }

        initFragment()
    }
}
