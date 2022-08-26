package com.example.Videos.WrapperObjects;

import com.example.Videos.Entity.Video;

import java.util.ArrayList;
import java.util.List;

public class VideoList {

    private List<Video> videoList;

    public VideoList() {

        videoList = new ArrayList<>();
    }

    public VideoList(List<Video> videoList) {
        this.videoList = videoList;
    }

    public List<Video> getVideoList() {
        return videoList;
    }

    public void setVideoList(List<Video> videoList) {
        this.videoList = videoList;
    }



}
