package com.example.Videos.Entity;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "Video")
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private Long ownerId;

    @Column(length = 45, nullable = false)
    private String ownerName;

    @Column(name = "title", length = 45, nullable = false)
    private String title;

    @Column(name = "body", length = 900, nullable = false)
    private String body;

    @Column( length = 128             )
    private String imageUrl;

    @Column( length = 128            )
    private String Url;

    @Column( length = 128 )
    private String tags;

    @Column( length = 128 )
    private String sourceUrl;


    @Column( length = 128  )
    private long likes;

    @Column( length = 128  )
    private long dislikes;

    @Column( length = 128  )
    private Date upLoaded;


    public Video() {
    }

    public Video(Long ownerId, String title, String body) {
        this.ownerId = ownerId;
        this.title = title;
        this.body = body;

    }


    public Video(Long ownerId, String title, String body, String imageUrl, String url, String sourceUrl) {
        this.ownerId = ownerId;
        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        this.Url = url;
        this.sourceUrl = sourceUrl;
    }

    public Video(Long ownerId, String ownerName, String title, String body, String imageUrl, String url, String tags, String sourceUrl) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        Url = url;
        this.tags = tags;
        this.sourceUrl = sourceUrl;
    }




    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
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

    public Long getId() {
        return id;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public void setId(Long id) {
        this.id = id;
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
}
