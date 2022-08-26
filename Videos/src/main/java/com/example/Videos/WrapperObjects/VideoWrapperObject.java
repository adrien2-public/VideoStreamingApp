package com.example.Videos.WrapperObjects;


import java.util.Date;
import java.util.List;

public class VideoWrapperObject {

/*


 id?: number;
    author: string;
    title: string;
    url: string;
    body: string ,
    likes: number;
    dislikes: number;
    imageUrl: string;
    tags: string[];
    uploaded: string ;
 */

    private Long id;
    private String author;
    private String title;
    private String body;
    private String imageUrl;
    private String Url;
    private List<String> tags;
    private long likes;
    private long dislikes;
    private Date upLoaded;


    public VideoWrapperObject() {
    }

    public VideoWrapperObject(Long ownerId, String title, String body) {

        this.title = title;
        this.body = body;

    }

    public VideoWrapperObject(Long ownerId, String title,
                              String body, String imageUrl, String url) {

        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        this.Url = url;

    }

    public VideoWrapperObject(Long ownerId, String title, String body,
                              String imageUrl, String url, String sourceUrl) {

        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        this.Url = url;

    }

    public VideoWrapperObject( String title, String body, String imageUrl,
                              String url, List<String> tags) {

        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        this.Url = url;

        this.tags = tags;
    }

    public VideoWrapperObject(Long id, String title, String body,
                              String imageUrl, String url,
                              List<String> tags, long likes, long dislikes, Date upLoaded) {
        this.id = id;

        this.title = title;
        this.body = body;
        this.imageUrl = imageUrl;
        this.Url = url;

        this.tags = tags;
        this.likes = likes;
        this.dislikes = dislikes;
        this.upLoaded = upLoaded;
    }



    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

   // public String getSourceUrl() {return sourceUrl;}

   // public void setSourceUrl(String sourceUrl) {this.sourceUrl = sourceUrl;}

    public void setId(Long id) {
        this.id = id;
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
