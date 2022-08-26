package com.example.Messages.Entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="conversations")
public class Conversation {

    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false)
    private Long convostarterId;

    @Column(length = 128, nullable = false)
    private Long convoReceiverId;

    @Column(length = 128, nullable = false)
    private LocalDateTime timestamp;


    public Conversation() {

    }

    public Conversation(Long convostarterId, Long convoReceiverId ) {
        this.id = id;
        this.convostarterId = convostarterId;
        this.convoReceiverId = convoReceiverId;
        this.timestamp =  LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
