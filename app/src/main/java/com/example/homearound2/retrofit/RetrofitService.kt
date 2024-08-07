package com.example.homearound2.retrofit

import android.annotation.SuppressLint
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService {

    //in order to prevent timeout
    val client: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(800,TimeUnit.SECONDS)
        .readTimeout(800,TimeUnit.SECONDS)
        .writeTimeout(800,TimeUnit.SECONDS)
        .build()

    var retrofit: Retrofit? = null
       private set
    @SuppressLint("NotConstructor")
    fun RetrofitService() {
        initializeRetrofit()
    }
    init {
        initializeRetrofit()
    }
    private fun initializeRetrofit() {
        retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.7:8080")
            .client(client)    //creation of client
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
    }
    //fun getRetrofit() : Retrofit? = retrofit

    /*fun getRetrofit():HouseAddsInfoAPI{
        val retrofit1 = Retrofit.Builder()
            .baseUrl("http://localhost:8080")
            .client(client)    //creation of client
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
        return retrofit1.create(HouseAddsInfoAPI::class.java)
    }*/

}