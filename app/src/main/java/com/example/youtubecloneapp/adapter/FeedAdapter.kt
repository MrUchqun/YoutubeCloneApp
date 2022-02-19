package com.example.youtubecloneapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubecloneapp.R
import com.example.youtubecloneapp.model.Feed
import com.example.youtubecloneapp.model.Shorts
import com.example.youtubecloneapp.model.Video
import com.google.android.material.imageview.ShapeableImageView

class FeedAdapter(var context: Context, var items: ArrayList<Feed>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_VIEW_VIDEO = 0
        private const val TYPE_VIEW_SHORT = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (items[position].shorts.size > 0) TYPE_VIEW_SHORT else TYPE_VIEW_VIDEO
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        if (viewType == TYPE_VIEW_SHORT) {
            val view =
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_feed_shorts, parent, false)
            return FeedShortsViewHolder(context, view)
        }

        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_feed_video, parent, false)
        return FeedViewHolder(view)
    }

    class FeedShortsViewHolder(context: Context, view: View) : RecyclerView.ViewHolder(view) {
        val rvShorts: RecyclerView = view.findViewById(R.id.rv_shorts)

        init {
            rvShorts.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        }
    }

    class FeedViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val ivProfile: ShapeableImageView = view.findViewById(R.id.iv_profile)
        val ivPhoto: ImageView = view.findViewById(R.id.iv_photo)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val feed = items[position]
        if (holder is FeedViewHolder) {
            holder.ivProfile.setImageResource(feed.video!!.profile)
            holder.ivPhoto.setImageResource(feed.video!!.photo)
        }

        if (holder is FeedShortsViewHolder) {
            refreshAdapter(holder.rvShorts, feed.shorts)
        }
    }

    private fun refreshAdapter(rvShorts: RecyclerView, shorts: ArrayList<Shorts>) {
        rvShorts.adapter = ShortsAdapter(context, shorts)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}