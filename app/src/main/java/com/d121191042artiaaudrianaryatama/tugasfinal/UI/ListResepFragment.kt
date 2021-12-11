package com.d121191042artiaaudrianaryatama.tugasfinal.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.d121191042artiaaudrianaryatama.tugasfinal.Adapter.ResepAdapter
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.DaftarResep
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.result
import com.d121191042artiaaudrianaryatama.tugasfinal.Network.WebServiceClient
import com.d121191042artiaaudrianaryatama.tugasfinal.R
import kotlinx.android.synthetic.main.fragment_list_resep.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListResepFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list_resep, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyvw.setHasFixedSize(true)
        recyvw.layoutManager = LinearLayoutManager(context)
        WebServiceClient.instance.getResepFromAPI().enqueue(object : Callback<DaftarResep> {
            override fun onFailure(call: Call<DaftarResep>, t: Throwable) {
                Log.e("ListResepFragment", "onFailure")
            }

            override fun onResponse(call: Call<DaftarResep>, response: Response<DaftarResep>) {
                val data = response.body()?.results
                recyvw.adapter = ResepAdapter(data as ArrayList<result>)
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = ListResepFragment()
    }
}