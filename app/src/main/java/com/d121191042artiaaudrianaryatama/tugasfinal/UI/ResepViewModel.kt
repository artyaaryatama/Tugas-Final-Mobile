package com.d121191042artiaaudrianaryatama.tugasfinal.UI

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.d121191042artiaaudrianaryatama.tugasfinal.Adapter.ResepAdapter
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.DaftarResep
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.result
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.results
import com.d121191042artiaaudrianaryatama.tugasfinal.Network.WebServiceClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ResepViewModel() :ViewModel(){
    init {
        Log.d("HomeViewModel", "is created")
    }
    interface OnClickListener{
        fun onClick(key: String)
    }

    var listResep : List<result>? = null
    var detailResep: results? = null

    fun getDataFromApi(recyclerView: RecyclerView, listener: ResepViewModel.OnClickListener){
        WebServiceClient.instance.getResepFromAPI().enqueue(object : Callback<DaftarResep> {
            override fun onResponse(call: Call<DaftarResep>, response: Response<DaftarResep>) {
                listResep = response.body()!!.results
                recyclerView.adapter = ResepAdapter(response.body()!!.results, object : ResepAdapter.OnClickListener {
                    override fun onClick(key: String) {
                        listener.onClick(key)
                    }

                })
            }

            override fun onFailure(call: Call<DaftarResep>, t: Throwable) {
                Log.d("LisResepRepository", "onFailure")
            }

        })
    }
}