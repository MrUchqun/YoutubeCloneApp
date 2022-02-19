package com.example.youtubecloneapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubecloneapp.R
import com.example.youtubecloneapp.model.Filter

class FilterAdapter(var context: Context, var items: ArrayList<Filter>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_VIEW_EXPLORE = 0
        private const val TYPE_VIEW_FILTER = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) TYPE_VIEW_EXPLORE else TYPE_VIEW_FILTER
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_VIEW_EXPLORE) {
            val view =
                LayoutInflater.from(parent.context).inflate(R.layout.item_explore, parent, false)
            return ExploreViewHolder(view)
        }

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_filter, parent, false)
        return FilterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filter = items[position]

        if (holder is FilterViewHolder) {
            holder.tvTitle.text = filter.title
        }

        if (holder is ExploreViewHolder) {
            holder.tvTitle.text = filter.title
        }
    }

    class ExploreViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val cvExplore: CardView = view.findViewById(R.id.cv_explore)
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
    }

    class FilterViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tv_title)
    }

}
