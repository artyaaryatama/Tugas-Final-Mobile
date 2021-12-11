package com.d121191042artiaaudrianaryatama.tugasfinal.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.result
import com.d121191042artiaaudrianaryatama.tugasfinal.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_resep.view.*

class ResepAdapter(private val listResep : ArrayList<result>) : RecyclerView.Adapter<ResepAdapter.Holder>() {
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(resep : result){
            with(itemView){
                Picasso.get()
                    .load(resep.thumb)
                    .into(imagethumb)
                title.text = resep.title
                portion.text = resep.portion
                times.text = resep.times
                level.text = resep.dificulty

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResepAdapter.Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_resep, parent,false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listResep.size
    }

    override fun onBindViewHolder(holder: ResepAdapter.Holder, position: Int) {
        holder.bind(listResep[position])
    }
}