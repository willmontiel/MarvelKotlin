package com.example.desarrollo7.myapplication.controllers

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.TargetApi
import android.os.Build
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.desarrollo7.myapplication.MainActivity
import com.example.desarrollo7.myapplication.adapters.CharactersAdapter
import com.example.desarrollo7.myapplication.misc.EndlessRecyclerViewScrollListener
import com.example.desarrollo7.myapplication.rest.RestClient
import com.example.desarrollo7.myapplication.rest.api.Cons
import com.example.desarrollo7.myapplication.rest.services.CharacterService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by desarrollo7 on 1/03/17.
 */
class MainController(val mainActivity: MainActivity)

/**
 * Refresh the content
 */
fun MainActivity.refreshData() {
    adapter.notifyDataSetChanged()
    //adapter.notifyItemRangeChanged(0, items.size)
    showProgress(false, progressBar)
}

/**
 * Load data every time the scroll is ending
 */
fun MainActivity.loadNextDataFromApi(offset: Int) {
    getCharacters(offset, false)
}

fun MainActivity.setupRecyclerView() {
    binding.charactersContainerRecyclerView.let {
        recyclerView ->
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)
        // use a linear layout manager
        val mLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = mLayoutManager

        adapter = CharactersAdapter(items, applicationContext)
        recyclerView.adapter = adapter
        // Retain an instance so that you can call `resetState()` for fresh searches

        val scrollListener = object : EndlessRecyclerViewScrollListener(mLayoutManager) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                loadNextDataFromApi(page)
            }
        }
        // Adds the scroll listener to RecyclerView
        recyclerView.addOnScrollListener(scrollListener)
        showProgress(false, progressBar)
    }
}

fun MainActivity.getCharacters(page: Int, firstTime: Boolean) {
    showProgress(true, progressBar)

    RestClient.retrofit.create(CharacterService::class.java)
            .listAll(Cons.MARVEL_DEVELOPER_APIKEY, Cons.MARVEL_DEVELOPER_HASH, page.toString(), Cons.MARVEL_DEVELOPER_TIMESTAMP)
            .doOnError {
                it.printStackTrace()
            }
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                marvelResponse ->
                items.addAll(marvelResponse.data.results)
                if (firstTime) {
                    setupRecyclerView()
                } else {
                    refreshData()
                }
            }
            .subscribeOn(Schedulers.io())
            .subscribe()
}

/**
 * Shows the progress UI and hides the content while loading.
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
fun MainActivity.showProgress(show: Boolean, progress: View) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {

        val shortAnimTime = resources.getInteger(android.R.integer.config_shortAnimTime)

        progress.visibility = if (show) View.VISIBLE else View.GONE
        progress.animate().setDuration(shortAnimTime.toLong()).alpha(
                (if (show) 1 else 0).toFloat()).setListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                progress.visibility = if (show) View.VISIBLE else View.GONE
            }
        })
    } else {
        progress.visibility = if (show) View.VISIBLE else View.GONE
    }
}