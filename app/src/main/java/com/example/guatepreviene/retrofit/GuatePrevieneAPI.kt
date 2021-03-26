package com.example.guatepreviene.retrofit

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GuatePrevieneAPI {
    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") id: String?): Call<JsonObject?>?
}