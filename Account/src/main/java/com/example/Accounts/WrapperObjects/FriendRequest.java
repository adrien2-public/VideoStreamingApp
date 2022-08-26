package com.example.Accounts.WrapperObjects;

public class FriendRequest {

    private String username;

    public FriendRequest( ) {

    }

    public FriendRequest(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
