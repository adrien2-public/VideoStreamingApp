package com.example.Videos.WrapperObjects;

public class FeedbackWO {

    private long videoId;
    private long likes;
    private long dislikes;


    public FeedbackWO() {

    }

    public FeedbackWO(long videoId, long likes, long dislikes) {
        this.videoId = videoId;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public long getDislikes() {
        return dislikes;
    }

    public void setDislikes(long dislikes) {
        this.dislikes = dislikes;
    }
}
