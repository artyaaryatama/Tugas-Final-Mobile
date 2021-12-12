package com.d121191042artiaaudrianaryatama.tugasfinal.UI

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.d121191042artiaaudrianaryatama.tugasfinal.Adapter.ResepAdapter
import com.d121191042artiaaudrianaryatama.tugasfinal.R
import kotlinx.android.synthetic.main.fragment_list_resep.*


const val TAG = "HomeFragment"
class ListResepFragment : Fragment() {
    private lateinit var viewModel: ResepViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView")
        viewModel = ViewModelProvider(this).get(ResepViewModel::class.java)
        return inflater.inflate(R.layout.fragment_list_resep, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        recyvw.setHasFixedSize(true)
        recyvw.layoutManager = LinearLayoutManager(context)
        if (viewModel.ListResepRepository.listResep.isNullOrEmpty()) {
            viewModel.ListResepRepository.getDataFromApi(recyvw)
        } else {
            recyvw.adapter = ResepAdapter(viewModel.ListResepRepository.listResep!!)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    companion object {
        fun newInstance() = ListResepFragment()
    }
}