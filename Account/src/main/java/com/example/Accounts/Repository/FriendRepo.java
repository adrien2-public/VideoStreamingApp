package com.example.Accounts.Repository;


import com.example.Accounts.Entity.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FriendRepo extends JpaRepository<Friend, Long> {

    @Query("SELECT f FROM Friend f WHERE (f.accountId = :accountId) AND (f.friendId = :friendId)")
    public Friend getSpecificFriendship(@Param("accountId") Long accountId, @Param("friendId") Long friendId);


    @Query("SELECT f FROM Friend f WHERE f.accountId = :accountId  OR f.friendId = :accountId ")
    public List<Friend> getAllFriendshipsForAccount(@Param("accountId") Long accountId);


    @Query("DELETE  FROM Friend f WHERE (f.accountId = :accountId) AND (f.friendId = :friendId)")
    public void deleteSpecificFriendship(@Param("accountId") Long accountId, @Param("friendId") Long friendId);


    @Query("DELETE  FROM Friend f WHERE f.accountId = :accountId OR f.friendId = :accountId")
    public void deleteAllFriendshipsForAccount(@Param("accountId") Long accountId);



}
