package com.example.Messages.WrapperOjects;

import com.example.Messages.Entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

public class ConversationWO {


    private Long convoId;
    private Long convostarterId;
    private Long convoReceiverId;
    private LocalDateTime timestamp;
    private List<Comment> comments;

    public ConversationWO( Long id, Long starter, Long receiver, LocalDateTime timestamp, List<Comment> commentList) {
        this.convoId = id ;
        this.convostarterId = starter;
        this.convoReceiverId = receiver;
        this.timestamp = timestamp;
        this.comments = commentList;
    }



    public ConversationWO( ) {

    }


    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Long getConvostarterId() {
        return convostarterId;
    }

    public void setConvostarterId(Long convostarterId) {
        this.convostarterId = convostarterId;
    }

    public Long getConvoReceiverId() {
        return convoReceiverId;
    }

    public void setConvoReceiverId(Long convoReceiverId) {
        this.convoReceiverId = convoReceiverId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
