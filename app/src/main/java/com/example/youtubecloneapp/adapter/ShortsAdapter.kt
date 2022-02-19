package com.example.youtubecloneapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubecloneapp.R
import com.example.youtubecloneapp.model.Shorts

class ShortsAdapter(var context: Context, var shorts: ArrayList<Shorts>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_shorts_view, parent, false)
        return ShortsViewHolder(view)
    }

    class ShortsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivShorts: ImageView = view.findViewById(R.id.iv_shorts)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val short = shorts[position]
        if (holder is ShortsViewHolder) {
            holder.ivShorts.setImageResource(short.shorts)
        }
    }

    override fun getItemCount(): Int {
        return shorts.size
    }
}