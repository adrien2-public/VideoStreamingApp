package com.example.Videos.WrapperObjects;

import java.util.ArrayList;
import java.util.List;

public class FriendList {


    private List<FriendsWO> friends;

    public FriendList( ) {
        friends =  new ArrayList<>();
    }

    public FriendList(List<FriendsWO> friends) {
        this.friends =  friends;
    }


    public List<FriendsWO> getFriends() {
        return friends;
    }

    public void setFriends(List<FriendsWO> friends) {
        this.friends = friends;
    }

}
