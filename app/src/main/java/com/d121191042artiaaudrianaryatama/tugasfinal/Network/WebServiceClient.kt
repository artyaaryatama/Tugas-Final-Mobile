package com.d121191042artiaaudrianaryatama.tugasfinal.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebServiceClient {
    val base_url = "https://masak-apa.tomorisakura.vercel.app"

    val instance : BackEndApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(BackEndApi::class.java)
    }
}