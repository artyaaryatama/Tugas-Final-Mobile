package com.d121191042artiaaudrianaryatama.tugasfinal.UI

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class ResepViewModel :ViewModel(){
    var ListResepRepository : ListResepRepository
    init {
        Log.d("HomeViewModel", "is created")
        ListResepRepository = ListResepRepository()
    }

    fun getData(recyclerView: RecyclerView){
        ListResepRepository.getDataFromApi(recyclerView)
    }
}