package com.example.youtubecloneapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubecloneapp.R
import com.example.youtubecloneapp.adapter.FeedAdapter
import com.example.youtubecloneapp.adapter.FilterAdapter
import com.example.youtubecloneapp.model.Feed
import com.example.youtubecloneapp.model.Video
import com.example.youtubecloneapp.model.Filter
import com.example.youtubecloneapp.model.Shorts

class MainActivity : AppCompatActivity() {

    private lateinit var rvFilter: RecyclerView
    private lateinit var rvVideo: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        rvFilter = findViewById(R.id.rv_filter)
        rvVideo = findViewById(R.id.rv_videos)

        rvFilter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvVideo.layoutManager = GridLayoutManager(this, 1)

        refreshFilterAdapter(getFilters())
        refreshFeedAdapter(getFeeds())
    }

    private fun refreshFeedAdapter(feeds: ArrayList<Feed>) {
        val adapter = FeedAdapter(this, feeds)
        rvVideo.adapter = adapter
    }

    private fun getFeeds(): ArrayList<Feed> {

        val shorts = ArrayList<Shorts>()
        for (i in 0..7) {
            shorts.add(Shorts(R.drawable.img_shorts_1))
            shorts.add(Shorts(R.drawable.img_profile))
            shorts.add(Shorts(R.drawable.img_shorts_2))
        }
        val index = (1..10).random()

        val feeds = ArrayList<Feed>()
        for (i in 0..10) {
            if (i == index) feeds.add(Feed(shorts))
            feeds.add(Feed(Video(R.drawable.img_profile, R.drawable.img_video)))
            feeds.add(Feed(Video(R.drawable.img_pdp_profile, R.drawable.img_pdp_video)))
        }
        return feeds
    }

    private fun refreshFilterAdapter(filters: ArrayList<Filter>) {
        val adapter = FilterAdapter(this, filters)
        rvFilter.adapter = adapter
    }

    private fun getFilters(): ArrayList<Filter> {
        val filters = ArrayList<Filter>()
        filters.add(Filter("Explore"))
        filters.add(Filter("All"))
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        return filters
    }


}