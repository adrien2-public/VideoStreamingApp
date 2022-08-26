package com.example.Messages.WrapperOjects;

import java.time.LocalDateTime;

public class CommentWO {


    private Long id;
    private Long conversationId;
    private Long senderId;
    private String authorName;
    private Long recipientId;
    private String body;
    private LocalDateTime timestamp;

    public CommentWO(Long conversationId, Long senderId, Long recipientId, String body, LocalDateTime timestamp) {
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.body = body;
        this.timestamp = LocalDateTime.now();
    }

    public CommentWO(Long conversationId, Long senderId, Long recipientId, String recipientName, String senderName, String body, LocalDateTime timestamp) {
        this.conversationId = conversationId;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.authorName = senderName;
        this.body = body;
        this.timestamp = timestamp;
    }

    public CommentWO() {

    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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


}