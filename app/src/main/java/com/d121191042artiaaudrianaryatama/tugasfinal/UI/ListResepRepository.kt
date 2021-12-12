package com.d121191042artiaaudrianaryatama.tugasfinal.UI


import com.d121191042artiaaudrianaryatama.tugasfinal.Adapter.ResepAdapter
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.DaftarResep
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.result
import com.d121191042artiaaudrianaryatama.tugasfinal.Network.WebServiceClient
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListResepRepository() {

    var listResep : List<result>? = null

    fun getDataFromApi(recyclerView: RecyclerView){
        WebServiceClient.instance.getResepFromAPI().enqueue(object : Callback<DaftarResep>{
            override fun onResponse(call: Call<DaftarResep>, response: Response<DaftarResep>) {
                listResep = response.body()!!.results
                recyclerView.adapter = ResepAdapter(response.body()!!.results)
            }

            override fun onFailure(call: Call<DaftarResep>, t: Throwable) {
                Log.d("LisResepRepository", "onFailure")
            }

        })
    }

}