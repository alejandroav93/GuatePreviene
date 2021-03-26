package com.example.guatepreviene.retrofit

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GuatePrevieneAPI {

    @GET("information")
    fun getEmergencies(): Call<JsonObject?>?

    @GET("covid")
    fun getStatistics(): Call<JsonObject?>?

    @GET("news")
    fun getNews(): Call<List<JsonObject?>?>?

    @GET("centres")
    fun getMaps(): Call<List<JsonObject?>?>?
}