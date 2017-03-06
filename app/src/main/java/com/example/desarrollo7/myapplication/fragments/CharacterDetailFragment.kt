package com.example.desarrollo7.myapplication.fragments

import android.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.desarrollo7.myapplication.R
import com.example.desarrollo7.myapplication.controllers.CharacterController
import com.example.desarrollo7.myapplication.databinding.FragmentCharacterDetailBinding
import com.example.desarrollo7.myapplication.holders.CharacterHolder
import com.example.desarrollo7.myapplication.models.Character
import com.example.desarrollo7.myapplication.rest.RestClient
import com.example.desarrollo7.myapplication.rest.api.Cons
import com.example.desarrollo7.myapplication.rest.services.CharacterService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by desarrollo7 on 3/03/17.
 */
class CharacterDetailFragment : Fragment() {
    lateinit var binding: FragmentCharacterDetailBinding
    lateinit var controller: CharacterController
    lateinit var progressBar: View
    var idChar: String = "0"

    companion object {
        fun newInstance(idChar: String, characterController: CharacterController): CharacterDetailFragment {
            val fragment = CharacterDetailFragment()
            fragment.controller = characterController
            fragment.idChar = idChar
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_character_detail, null, false)
        progressBar = binding.characterProgressBar

        getCharacter()
        return binding.root
    }

    fun getCharacter() {
        RestClient.retrofit.create(CharacterService::class.java)
                .listOne(idChar.toInt(), Cons.MARVEL_DEVELOPER_APIKEY, Cons.MARVEL_DEVELOPER_HASH, Cons.MARVEL_DEVELOPER_TIMESTAMP)
                .doOnError {
                    it.printStackTrace()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext {
                    marvelResponse ->
                    setCharacter(marvelResponse.data.results)
                }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }

    fun setCharacter(item: List<Character>) {
        var holder: CharacterHolder = CharacterHolder(binding, activity.applicationContext, controller)
        holder.character = item.first()
        holder.setSummaryData()
    }
}