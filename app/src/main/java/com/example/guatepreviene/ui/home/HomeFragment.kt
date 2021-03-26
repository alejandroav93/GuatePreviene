package com.example.guatepreviene.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.guatepreviene.BuildConfig
import com.example.guatepreviene.R
import com.example.guatepreviene.retrofit.Retrofit2
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlinx.android.synthetic.main.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?

    ): View? {

        val retrofit2 = Retrofit2()
        retrofit2.service.getEmergencies()?.enqueue(object :
            Callback<JsonObject?> {
            override fun onResponse(call: Call<JsonObject?>, response: Response<JsonObject?>) {
                if (response.isSuccessful) {
                    val data: JsonObject? = response.body()
                    if (BuildConfig.DEBUG && data == null) {
                        error("Assertion failed")
                    }
                    val print = ("\n\nHabilidad: " +
                            data!!.getAsJsonArray("abilities")[1].asJsonObject
                                .getAsJsonObject("ability")["name"].toString().toUpperCase(Locale.ROOT)
                            + "\nID: " + data["id"]
                            + "\nNombre: " + data["name"].toString().toUpperCase(Locale.ROOT)
                            + "\nExperiencia Base: " + data["base_experience"] +
                            "\nAltura: " + data["height"] + "0 cm"
                            + "\nPeso: " + data["weight"] + " gramos")
                    pokemon.text = print
                    Log.i("Pokemon", data.toString())
                } else {
                    Log.e("Error", "Hubo un error inesperado!")
                }
            }

            override fun onFailure(call: Call<JsonObject?>, t: Throwable) {
                Log.e("Error", t.toString())
            }
        })
    }
}