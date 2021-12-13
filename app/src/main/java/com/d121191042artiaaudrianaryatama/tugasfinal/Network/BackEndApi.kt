package com.d121191042artiaaudrianaryatama.tugasfinal.Network

import retrofit2.Call
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.DaftarResep
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.DetailResep
import retrofit2.http.GET
import retrofit2.http.Url

interface BackEndApi {
    @GET("api/categorys/recipes/resep-daging")
    fun getResepFromAPI() : Call<DaftarResep>

    @GET
    fun getDetailResep(@Url url: String) : Call<DetailResep>
}
