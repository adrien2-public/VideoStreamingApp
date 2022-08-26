package com.example.Videos.WrapperObjects;

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


}
