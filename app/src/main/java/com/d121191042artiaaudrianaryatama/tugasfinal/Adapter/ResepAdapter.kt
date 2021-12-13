package com.d121191042artiaaudrianaryatama.tugasfinal.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.d121191042artiaaudrianaryatama.tugasfinal.Model.result
import com.d121191042artiaaudrianaryatama.tugasfinal.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_resep.view.*

class ResepAdapter(private val listResep: List<result>, val listener: OnClickListener) : RecyclerView.Adapter<ResepAdapter.Holder>() {

    interface OnClickListener {
        fun onClick(key : String)
    }
    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(resep : result, listener: OnClickListener){
            with(itemView){
                Picasso.get()
                    .load(resep.thumb)
                    .into(imagethumb)
                title.text = resep.title
                portion.text = resep.portion
                times.text = resep.times
                level.text = resep.dificulty

                itemView.setOnClickListener{
                    listener.onClick(resep.key!!)


                }

            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_resep, parent,false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(listResep.get(position), listener)
    }
    override fun getItemCount(): Int {
        return listResep.size
    }

    companion object {
        var key = ""
    }
}