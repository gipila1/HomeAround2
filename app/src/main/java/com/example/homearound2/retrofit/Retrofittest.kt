package com.example.homearound2.retrofit

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofittest {
    var retrofit: Retrofit? = null
    fun RetrofitService() {
        initializeRetrofit()
    }

    private fun initializeRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.7:8080")
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }
}