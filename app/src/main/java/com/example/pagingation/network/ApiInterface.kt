package com.example.movieappkotlin.network

import com.example.pagingation.model.character.CharacterResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("character/")
    suspend fun getAllCharacters(@Query("page")page:Int
    ): Response<CharacterResponse>



}