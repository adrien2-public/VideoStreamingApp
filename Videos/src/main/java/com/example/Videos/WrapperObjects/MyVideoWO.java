package com.example.Videos.WrapperObjects;

import java.util.Date;
import java.util.List;

public class MyVideoWO {

    private Long id;
    private Long ownerId;
    private String title;
    private String body;
    private String imageUrl;
    private String Url;
    private String sourceUrl;
    private List<String> tags;
    private long likes;
    private long dislikes;
    private Date upLoaded;
    private String author;

    public MyVideoWO() {

    }

    public MyVideoWO(Long id, Long ownerId, String title, String body, String imageUrl,
                     String url, String sourceUrl, List<String> tags,
                     long likes, long dislikes, Date upLoaded) {
        this.id = id;
        this.ownerId = ownerId;
        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        this.Url = url;
        this.sourceUrl = sourceUrl;
        this.tags = tags;
        this.likes = likes;
        this.dislikes = dislikes;
        this.upLoaded = upLoaded;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

    public Date getUpLoaded() {
        return upLoaded;
    }

    public void setUpLoaded(Date upLoaded) {
        this.upLoaded = upLoaded;
    }
}
