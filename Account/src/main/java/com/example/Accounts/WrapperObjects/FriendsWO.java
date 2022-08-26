package com.example.Accounts.WrapperObjects;

public class FriendsWO {

    private String firstName;
    private String username;
    private Long friendId;

    public FriendsWO() {
    }
    public FriendsWO(String name, String username, Long id ) {
        this.firstName = name;
        this.username = username;
        this.friendId = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getUsername() {
        return username;
    }
    public Long getFriendId() {
        return friendId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }
}

