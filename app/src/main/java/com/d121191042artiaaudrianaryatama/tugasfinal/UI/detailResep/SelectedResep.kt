package com.d121191042artiaaudrianaryatama.tugasfinal.UI.detailResep

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.results
import com.d121191042artiaaudrianaryatama.tugasfinal.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_resep.*


class SelectedResep(var key : String) : Fragment() {
    lateinit var viewModel: SelectedResepViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(SelectedResepViewModel::class.java)
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_resep, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (viewModel.detailResep == null){
            viewModel.getDetailResepFromApi(key, object : SelectedResepViewModel.UI{
                override fun setUI(results: results) {
                    setUIinFragment(results)

                }

            })
        } else{
            setUIinFragment(viewModel.detailResep!!)
        }
    }

    private fun setUIinFragment(results: results){
        Picasso.get()
            .load(results.thumb)
            .into(imagethumb)

        title.text = results.title
    }

    companion object {
        var key = ""

        @JvmStatic
        fun newInstance(key: String) = SelectedResep(key)
    }
}