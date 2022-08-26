package com.example.Accounts.Entity;


import javax.persistence.*;

@Entity
@Table(name= "PendingFriendRequests")
public class PendingFriendRequests {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false)
    private Long accountId;

    @Column(length = 128, nullable = false)
    private Long receiverId;

    public PendingFriendRequests() {

    }

    public PendingFriendRequests(Long accountId, Long receiverId) {
        this.accountId = accountId;
        this.receiverId = receiverId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Long receiverId) {
        this.receiverId = receiverId;
    }

    @Override
    public String toString() {
        return  id + "," + accountId + "," + receiverId +  "," + "Be my friend";
    }
}
