package com.example.Videos.WrapperObjects;

import com.example.Videos.Entity.Video;

import java.util.ArrayList;
import java.util.List;

public class MyVideoFeedWrapperObject {

    private List<Video> videos;

    public MyVideoFeedWrapperObject() {

    }
    public MyVideoFeedWrapperObject(List<Video> videos) {
        this.videos = videos;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void addVideoList(Video video) {
        if(this.videos == null){
            List<Video> videos = new ArrayList();
            this.videos.add(video);
        }
         this.videos.add(video);
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }




}
