package com.example.desarrollo7.myapplication.rest.services

import com.example.desarrollo7.myapplication.rest.api.Cons
import com.example.desarrollo7.myapplication.vos.MarvelResponse
import io.reactivex.Observable
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by desarrollo7 on 2/03/17.
 */
interface CharacterService {
    @GET(Cons.URL_ALL_CHARACTERS)
    fun listAll(@Query(Cons.APIKEY) apikey: String, @Query(Cons.HASH) hash: String, @Query(Cons.OFFSET) offset: String, @Query(Cons.TIMESTAMP) timestamp: String): Observable<MarvelResponse>
}