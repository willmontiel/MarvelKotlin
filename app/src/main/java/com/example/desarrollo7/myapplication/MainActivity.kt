package com.example.desarrollo7.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.databinding.DataBindingUtil
import android.view.View
import com.example.desarrollo7.myapplication.adapters.CharactersAdapter
import com.example.desarrollo7.myapplication.controllers.MainController
import com.example.desarrollo7.myapplication.controllers.getCharacters
import com.example.desarrollo7.myapplication.databinding.ActivityMainBinding
import com.example.desarrollo7.myapplication.models.Character


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var controller: MainController
    lateinit var layout: View
    lateinit var progressBar: View

    var offset: Int = 0
    var items: MutableList<Character> = mutableListOf()
    lateinit var adapter: CharactersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        layout = binding.charactersContainerRecyclerView
        progressBar = binding.mainProgressBar

        controller = MainController(this)

        getCharacters(offset, true)
    }
}
