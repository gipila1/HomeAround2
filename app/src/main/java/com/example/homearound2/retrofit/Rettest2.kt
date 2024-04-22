package com.example.homearound2.retrofit

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Rettest2 {
    var retrofit1: Retrofit? = null
        private set

    init {
        initializeRetrofit1()
    }

    private fun initializeRetrofit1() {
        retrofit1 = Retrofit.Builder()
            .baseUrl("http://192.168.1.7:8080")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }
}