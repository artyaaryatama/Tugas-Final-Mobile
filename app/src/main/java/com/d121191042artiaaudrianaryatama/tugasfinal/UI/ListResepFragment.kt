package com.d121191042artiaaudrianaryatama.tugasfinal.UI

import android.content.Intent
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
import com.d121191042artiaaudrianaryatama.tugasfinal.UI.detailResep.SelectedResepFragment
import kotlinx.android.synthetic.main.fragment_list_resep.*
import android.widget.Toast


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
        if (viewModel.listResep.isNullOrEmpty()){
            viewModel.getDataFromApi(recyvw, object : ResepViewModel.OnClickListener{
                override fun onClick(key: String) {
                    moveToSelectedResep(key)
                }

                override fun onShare(title: String) {
                    val sendIntent: Intent = Intent().apply {
                        action = Intent.ACTION_SEND
                        putExtra(Intent.EXTRA_TEXT, "Masak apa kamu hari ini? Yuk Cobain $title. Kamu bisa buka resep ini dengan download aplikasi disini yaa 😁 https://bit.ly/Resep-Makanan-Nusantara")
                        type = "text/plain"
                    }
                    val shareIntent = Intent.createChooser(sendIntent,null)
                    startActivity(shareIntent)
                }

            })
        }

        else {
            recyvw.adapter = ResepAdapter(viewModel.listResep!!, object :ResepAdapter.OnClickListener {
                override fun onClick(key: String) {
                    moveToSelectedResep(key)
                }

                override fun onShare(title: String) {
                    Toast.makeText(context, title, Toast.LENGTH_SHORT).show()
                }

            })
        }

    }

    fun moveToSelectedResep(key: String){
        SelectedResepFragment.key = key
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(R.id.container, SelectedResepFragment.newInstance(key))
            ?.commitNow()
    }


    companion object {
        fun newInstance() = ListResepFragment()
    }
}