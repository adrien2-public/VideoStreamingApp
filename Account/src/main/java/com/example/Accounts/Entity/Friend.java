package com.example.Accounts.Entity;


import javax.persistence.*;

@Entity
@Table(name= "Friends")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 128, nullable = false)
    private long accountId;

    @Column(length = 128, nullable = false)
    private long friendId;


    @Column(length = 128, nullable = false)
    private String friendName;

    @Column(length = 128, nullable = false)
    private String username;

    public Friend() {

    }

    public Friend(Long accountId, Long friendId) {
        this.accountId = accountId;
        this.friendId = friendId;
    }

    public Friend(Long accountId, Long friendId,  String friendName, String username) {
        this.accountId = accountId;
        this.friendId = friendId;
        this.friendName = friendName;
        this.username = username;
    }

    public Long getAccountId() {
        return accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }



    public String getFriendName() {
        return friendName;
    }

    public void setFriendName(String friendName) {
        this.friendName = friendName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
