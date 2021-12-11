package com.d121191042artiaaudrianaryatama.tugasfinal.Network


import com.d121191042artiaaudrianaryatama.tugasfinal.Model.DaftarResep
import retrofit2.Call
import retrofit2.http.GET

interface BackEndApi {
    @GET("https://masak-apa-tomorisakura.vercel.app/api/categorys/recipes/resep-daging")
    fun getResepFromAPI() : Call<DaftarResep>

}