package com.example.youtubecloneapp.model

class Feed {
    var video: Video? = null
    var shorts: ArrayList<Shorts> = ArrayList()

    constructor(video: Video){
        this.video = video
    }

    constructor(shorts: ArrayList<Shorts>){
        this.shorts = shorts
    }
}