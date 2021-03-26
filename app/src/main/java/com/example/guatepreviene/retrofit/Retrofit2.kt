package com.example.guatepreviene.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Retrofit2 {
    val service: GuatePrevieneAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl(Utils.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        service = retrofit.create(GuatePrevieneAPI::class.java)
    }
}