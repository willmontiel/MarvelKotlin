package com.example.desarrollo7.myapplication.rest

import com.example.desarrollo7.myapplication.rest.api.Cons
import retrofit2.Retrofit
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by desarrollo7 on 2/03/17.
 */
object RestClient {
    var retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(Cons.URL_BASE)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}