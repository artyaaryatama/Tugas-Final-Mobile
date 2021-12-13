package com.d121191042artiaaudrianaryatama.tugasfinal.UI.detailResep

import android.util.Log
import androidx.lifecycle.ViewModel
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.DetailResep
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.results
import com.d121191042artiaaudrianaryatama.tugasfinal.Network.WebServiceClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SelectedResepViewModel: ViewModel() {
    var detailResep: results? = null
    init {
        Log.d("SelectedResepViewModel", "created")
    }

    interface UI{
        fun setUI(results: results)
    }

    fun getDetailResepFromApi(key: String, ui : SelectedResepViewModel.UI) {
        WebServiceClient.instance.getDetailResep(getUrl(key)).enqueue(object :
            Callback<DetailResep> {
            override fun onResponse(call: Call<DetailResep>, response: Response<DetailResep>) {
                detailResep = response.body()?.results
                ui.setUI(detailResep!!)
            }

            override fun onFailure(call: Call<DetailResep>, t: Throwable) {
                Log.d("LisResepRepository", "onFailure")
            }

        })

    }

    fun getUrl(key: String): String{
        var endpoint = "/api/recipe/$key"
        return endpoint
    }

}