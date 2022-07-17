package com.example.movieappkotlin.network

import com.nurbk.ps.movieappq.others.StringConstants
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object{

        fun getClient(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(StringConstants.baseUrl)
                 .build()
            return retrofit.create(ApiInterface::class.java)
        }


    }
}