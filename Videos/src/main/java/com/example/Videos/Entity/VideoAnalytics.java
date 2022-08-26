package com.example.Videos.Entity;

import javax.persistence.*;

@Entity
@Table(name= "VideoAnalytics")
public class VideoAnalytics {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column( length = 45  )
    private long videoId;

    @Column( length = 45  )
    private long visitorId;

    @Column( length = 45  )
    private long watchTime;

    @Column( length = 45  )
    private long playCount;

    @Column( length = 45  )
    private long resumeCount;

    @Column( length = 45  )
    private long pauseCount;

    @Column( length = 45  )
    private long seekCount;

    public VideoAnalytics() {

    }

    public VideoAnalytics( long videoId, long visitorId, long watchTime, long playCount, long resumeCount, long pauseCount, long seekCount) {

        this.videoId = videoId;
        this.visitorId = visitorId;
        this.watchTime = watchTime;
        this.playCount = playCount;
        this.resumeCount = resumeCount;
        this.pauseCount = pauseCount;
        this.seekCount = seekCount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getVideoId() {
        return videoId;
    }

    public void setVideoId(long videoId) {
        this.videoId = videoId;
    }

    public long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(long visitorId) {
        this.visitorId = visitorId;
    }

    public long getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(long watchTime) {
        this.watchTime = watchTime;
    }

    public long getPlayCount() {
        return playCount;
    }

    public void setPlayCount(long playCount) {
        this.playCount = playCount;
    }

    public long getResumeCount() {
        return resumeCount;
    }

    public void setResumeCount(long resumeCount) {
        this.resumeCount = resumeCount;
    }

    public long getPauseCount() {
        return pauseCount;
    }

    public void setPauseCount(long pauseCount) {
        this.pauseCount = pauseCount;
    }

    public long getSeekCount() {
        return seekCount;
    }

    public void setSeekCount(long seekCount) {
        this.seekCount = seekCount;
    }


    /*

      videoId?: number;
    visitorId: number;
    watchTime: number;
    playCount: number;
    resumeCount: number;
    pauseCount: number;
    seekCount: number;
     */
}
