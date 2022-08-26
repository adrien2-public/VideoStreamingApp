package com.example.Messages.Entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false)
    private Long conversationId;

    @Column(length = 128, nullable = false)
    private Long senderId;

    @Column(length = 128, nullable = false)
    private Long recipientId;

    @Column(length = 500, nullable = false)
    private String body;

    @Column(length = 128, nullable = false)
    private LocalDateTime timestamp;


    @Column(length = 128)
    private String authorName;

    public Comment(Long conversationId, Long senderId, Long recipientId, String body) {
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.body = body;
        this.timestamp = LocalDateTime.now();
    }

    public Comment(Long conversationId, Long senderId, Long recipientId, String body, String senderName) {
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.body = body;
        this.timestamp =  LocalDateTime.now();
        this.authorName = senderName;
    }

    public Comment() {

    }

    public Long getConversationId() {
        return conversationId;
    }

    public void setConversationId(Long conversationId) {
        this.conversationId = conversationId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }


    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
